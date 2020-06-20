package com.huzhu.filter;


import com.huzhu.util.ConstantHuZhu;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器步骤
 * 1.导包：到一个正确Servlet下的包，实现 Filter
 * 2.实现方法都Filter
 * （1）实现过滤
 * （2）释放
 * 3.配置过滤器web.xml
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=====过滤器LoginFilter初始化=====");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("=====LoginFilter过滤开始=====");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getSession().getAttribute(ConstantHuZhu.USER_SESSION)==null){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect(request.getContextPath()+"/LogOffServlet");
        }
        filterChain.doFilter(servletRequest,servletResponse);//转发给其他过滤器或者Servlet
        System.out.println("=====LoginFilter转发完成，过滤结束======");
    }

    public void destroy() {
        System.out.println("====LoginFilter过滤器销毁=====");
    }
}
