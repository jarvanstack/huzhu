package com.huzhu.service.Interface;

import com.huzhu.pojo.HuZhu_User;

public interface UserService {
    //用户登录接口
    public HuZhu_User login( String log_name,String password );
}
