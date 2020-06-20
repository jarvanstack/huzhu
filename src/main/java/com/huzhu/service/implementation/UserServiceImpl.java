package com.huzhu.service.implementation;

import com.huzhu.dao.Interface.UserDao;
import com.huzhu.dao.implementation.UserDaoImpl;
import com.huzhu.pojo.HuZhu_User;
import com.huzhu.service.Interface.UserService;
import com.huzhu.util.jdbc.JdbcPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    //业务层都要调用dao层，所以我们要引入dao层
    private UserDao userDao;

    /**
     * 构造的时候实例化UserDao
     */
    public UserServiceImpl() {
        //调用它的实现类
        userDao = new UserDaoImpl();
    }

    //返回User或者null
    @Override
    public HuZhu_User login(String log_name, String password) {
        System.out.println("test-----UserServiceImpl");
        Connection connection = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet= null;
        HuZhu_User huZhu_user = null;

        try {
            huZhu_user = userDao.getLoginUser(connection, preStatement, resultSet, log_name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //为了大家能在这里统一关闭把值都赋值到底层去了。哎。。冲
            if (JdbcPool.release(connection,preStatement,resultSet)){
                System.out.println("资源释放成功");
            }
        }
        return huZhu_user;
    }
}
