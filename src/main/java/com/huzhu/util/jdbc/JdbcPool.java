package com.huzhu.util.jdbc;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;

/**
 * JdbcPool 数据池（数据源）
 * #### 一.myJdbcPool.java实现步骤
 * 1.在loadConfiguration()批量生产配置的Connection放到Victor里面（Victor线程安全）
 * 2.在getConnection()方法里，
 * * （1）.在集合victors取出一个Connection，
 * *  (2).并使用[动态代理技术]()修改close()方法，让其变成归还connection对象到集合里。
 */
public class JdbcPool  {
    public static Vector<Connection> victors = new Vector();
    private static void loadConfiguration() {
        try {
            InputStream inputStream = JdbcPool.class.getClassLoader().getResourceAsStream("jdbcPoolConf.properties");
            Properties properties = new Properties();

            //将输入流的数据载入到Properties对象里，inputSteam都可以？
            assert inputStream != null;
            properties.load(inputStream);
            //用properties对象获得配置文件的信息
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            int jdbcPoolInitSize = Integer.parseInt(properties.getProperty("jdbcPoolInitSize"));
            //驱动
            Class.forName(properties.getProperty("driver"));
            //如果没有初始化就初始化，
            if (victors.size() == 0) {
                for (int i = 0; i < jdbcPoolInitSize; i++) {
                    Connection connection = DriverManager.getConnection(url, user, password);
                    System.out.println("日志--获取到Connection:" + i);
                    victors.addElement(connection);
                }
            }
        } catch (Exception e) {
            System.out.println("日志--创建失败!");
            e.printStackTrace();
        }

    }


    //获得Connection
    public static Connection getConnection() {
        if (victors.size() == 0) {
            JdbcPool.loadConfiguration();
        }
        if (victors.size() > 0) {
            //取出一个 Connection,并给final？
            final Connection connection = victors.remove(0);
            //关键的动态代理技术，实现修改connection的close方法
            return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), connection.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
                    if (!method.getName().equals("close")) {
                        return method.invoke(connection, args);
                    } else {
                        //如果调用的是Connection对象的close方法，就把conn还给数据库连接池
                        victors.addElement(connection);
                        System.out.println(connection + "被还给Connections数据库连接池了！！");
                        System.out.println("Connections数据库连接池大小为" + victors.size());
                        return null;
                    }
                }
            });
        } else {
            System.out.println("日志--链接超时！");
            return null;
        }
    }

    //释放资源
    public static boolean release(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        boolean isSuccess = true;
        //先开后关
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                isSuccess = false;
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                isSuccess = false;
            }
        }
        if (connection != null) {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
                isSuccess = false;
            }
        }
        return isSuccess;

    }

    //公共方法查询
    public static ResultSet executeQuery(Connection connection,PreparedStatement preStatement, String sql,Object []columns) throws SQLException {
        System.out.println("---------JdbcPoll");
        if (connection!=null && columns.length>0) {
            preStatement = connection.prepareStatement(sql);
            for (int i = 0; i < columns.length; i++) {
                preStatement.setObject(i + 1, columns[i]);
            }
            return preStatement.executeQuery();
        }
        else {
            System.out.println("查询失败");
            return null;
        }
    }


    //增删改
    public static int executeUpdate(Connection connection, PreparedStatement preStatement,String sql,Object []columns) throws SQLException {
        if (connection != null) {
            preStatement = connection.prepareStatement(sql);
            for (int i = 0; i < columns.length; i++) {
                preStatement.setObject(i + 1, columns[i]);
            }
            return preStatement.executeUpdate();
        }else {
            System.out.println("Update失败");
            return -1;
        }
    }


}
