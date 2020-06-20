package com.huzhu.filter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 实现HttpSessionListener接口，
 * 写一个监听类，完成对网站在人数的监听
 */
public class OnlineUserListener implements HttpSessionListener {
    //当一个用户打开网站的时候开启创建session执行的方法
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        if (context.getAttribute("onlineUsers")!=null){
            context.setAttribute("onlineUsers",(Integer)context.getAttribute("onlineUsers")+1);
        }
        else {
            context.setAttribute("onlineUsers", 1);
        }
        System.out.println("=====有一位用户上线了=====");
        System.out.println("Id: "+httpSessionEvent.getSession().getId()+"=====");
    }
    //关闭网站的时候销毁session执行的的方法
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        if (context.getAttribute("onlineUsers")!=null){
            context.setAttribute("onlineUsers", 0);
        }
        else {
            context.setAttribute("onlineUsers",(Integer)context.getAttribute("onlineUsers")-1);
        }
        System.out.println("=====用户下线了=====");
        System.out.println("Id: "+httpSessionEvent.getSession().getId()+"=====");
    }
}
