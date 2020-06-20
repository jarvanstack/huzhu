package com.huzhu.dao.implementation;

import com.huzhu.dao.Interface.UserDao;
import com.huzhu.pojo.HuZhu_User;
import com.huzhu.util.jdbc.JdbcPool;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class UserDaoImpl implements UserDao {
    //返回实例化后的用户
    @Override
    public HuZhu_User getLoginUser(Connection connection, PreparedStatement preStatement, ResultSet resultSet,String log_name, String password) throws SQLException {
        System.out.println("--------UserDaoImpl");
        HuZhu_User huZhu_user = null;
        connection = JdbcPool.getConnection();
        if (connection != null) {
            String sql = "select * from huzhu.huzhu_user where log_name = ? and password = ?";
            Object[] columns = {log_name, password};
            connection = JdbcPool.getConnection();
            resultSet = JdbcPool.executeQuery(connection, preStatement,sql, columns);
            assert resultSet != null;
            if (resultSet.next()) {
                huZhu_user = new HuZhu_User();
                huZhu_user.setId(resultSet.getInt("id"));
                huZhu_user.setLog_name(resultSet.getString("log_name"));
                huZhu_user.setPassword(resultSet.getString("password"));
                huZhu_user.setBirth(resultSet.getDate("birth"));
                huZhu_user.setAdddress(resultSet.getString("address"));
                huZhu_user.setMail_box(resultSet.getString("mail_box"));
                huZhu_user.setUser_role_id(resultSet.getInt("user_role_id"));
            }
        }
        return huZhu_user;
    }
}
