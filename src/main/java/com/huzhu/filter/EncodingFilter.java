package com.huzhu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器步骤
 * 1.导包：到一个正确Servlet下的包，实现 Filter
 * 2.实现方法都Filter
 * （1）实现过滤
 * （2）释放
 * 3.配置过滤器web.xml
 */
public class EncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=====EncodingFilter启动初始化=====");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("=====EncodingFilter开始=====");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);//转发给其他过滤器或者Servlet
        System.out.println("=====EncodingFilter，过滤结束======");
    }

    public void destroy() {
        System.out.println("====EncodingFilter过滤器销毁=====");
    }
}
