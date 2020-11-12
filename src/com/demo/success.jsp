<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/1
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录成功</title>
</head>
<body>
<div style="font:100px bolder ; text-align:center;">
<%String s =(String)request.getAttribute( "ValueA ");%>
hello,<%=s%>
</div>
<hr>
<a href="Login.jsp">重新登录</a>
<br>
<a href="register.jsp">注册</a>
<br>
<a href="change.jsp">修改密码</a>
</body>
</html>
