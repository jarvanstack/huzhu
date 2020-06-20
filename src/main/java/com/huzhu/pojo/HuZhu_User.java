package com.huzhu.pojo;

import java.util.Date;

public class HuZhu_User {
    private Integer id;      //user主键
    private String log_name; //用户登录名称
    private String name;  //用户名
    private String password;//用户的密码
    private String gengder;//性别（默认男）
    private Date birth;//出生日期
    private String adddress;//地址
    private String mail_box;//邮箱
    private int user_role_id;//权限id，用户2
    private int age;//年龄可计算出来


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLog_name() {
        return log_name;
    }

    public void setLog_name(String log_name) {
        this.log_name = log_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGengder() {
        return gengder;
    }

    public void setGengder(String gengder) {
        this.gengder = gengder;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    public String getMail_box() {
        return mail_box;
    }

    public void setMail_box(String mail_box) {
        this.mail_box = mail_box;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public int getAge() {
        return new Date(System.currentTimeMillis()).getYear() - getBirth().getYear();
    }

    public void setAge(int age) {
        this.age = age;
    }
}
