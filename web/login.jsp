
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>登录界面login.jsp</h1>
<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
    登录名称<input type="text" name="username" >
    <br>
    登录密码<input type="password" name="password">
    <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
