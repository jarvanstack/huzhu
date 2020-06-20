package com.huzhu.servlet.login;

import com.huzhu.pojo.HuZhu_User;
import com.huzhu.service.implementation.UserServiceImpl;
import com.huzhu.util.ConstantHuZhu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现用户的的登录
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet start");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HuZhu_User huZhu_user = new UserServiceImpl().login(username,password);
        if (huZhu_user!=null){
            System.out.println("--登录成功");
            //保存对象
            req.getSession().setAttribute(ConstantHuZhu.USER_SESSION,huZhu_user);
            resp.sendRedirect("sys/homePage.jsp");
        }else {
            System.out.println("--登录失败");
            resp.sendRedirect("loginFailed.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
