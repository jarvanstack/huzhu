
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h1 style="color: aqua">登录成功！这里是主页homePage</h1>
<h2>登录成功！id = :<%=request.getAttribute("error")%></h2>
<a href="<%=request.getContextPath()%>/LogOffServlet">注销登录</a>
</body>
</html>
