package com.huzhu.util.jdbc;

import com.huzhu.pojo.HuZhu_User;

import java.sql.*;

/**
 * 这个包测试 JdbcPool 是否可用
 */
public class jdbcPoolTest {
    public static void main(String[] args) {
        new jdbcPoolTest().testQuery01();
    }

    /**
     * 测试查询
     */
    private void testQuery01(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcPool.getConnection();
            String sql = "select * from huzhu.huzhu_user where log_name = ?";
            HuZhu_User user = new HuZhu_User();
            user.setLog_name("zhangsan");
            Object [] columns = {user.getLog_name()};
            System.out.println(columns.length);
            resultSet = JdbcPool.executeQuery(connection,preparedStatement,sql,columns);
            System.out.println(preparedStatement);
            assert resultSet != null;
            while (resultSet.next()){
                System.out.println("姓名:"+resultSet.getObject("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcPool.release(connection,preparedStatement,resultSet);
        }

    }
}