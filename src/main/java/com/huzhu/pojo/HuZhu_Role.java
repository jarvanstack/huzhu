package com.huzhu.pojo;

public class HuZhu_Role {
    private int id;//role表主键
    private int role_code;//角色编码(比如管理员为1）
    private String role_name;//角色名称（比如 root)
    private String role_comment;//角色备注（比如管理员)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_code() {
        return role_code;
    }

    public void setRole_code(int role_code) {
        this.role_code = role_code;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_comment() {
        return role_comment;
    }

    public void setRole_comment(String role_comment) {
        this.role_comment = role_comment;
    }
}
