<%@ page import="com.huzhu.util.ConstantHuZhu" %>
<%@ page import="com.huzhu.pojo.HuZhu_User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h1 style="color: aqua">登录成功！这里是主页homePage</h1>
<%
    HuZhu_User huZhu_user = (HuZhu_User)request.getSession().getAttribute(ConstantHuZhu.USER_SESSION);
    String name = "";
    if (huZhu_user!=null){
        name = huZhu_user.getName();
    }
%>
<h2>登录成功！用户 :<%=name%></h2>
<a href="<%=request.getContextPath()%>/LogOffServlet">注销登录</a>
</body>
</html>
