package com.huzhu.dao.Interface;


import com.huzhu.pojo.HuZhu_User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {

    //返回实例化后的用户
    public HuZhu_User getLoginUser(Connection connection, PreparedStatement preStatement, ResultSet resultSet,String log_name, String password) throws SQLException;


}
