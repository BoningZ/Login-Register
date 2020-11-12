<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/1
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div style="text-align:center;margin-top:120px">
<form action="LoginServlet" method="post">
    <table style="margin-left:40%">
        <caption>登录</caption>

        <tr>
            <td>用户名：</td>
            <td><input type="text" size="21" name="username"/></td>

        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" size="21"/></td>
        </tr>

    </table>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
<br>
<a href="register.jsp">注册</a>
<br>
<a href="change.jsp">修改密码</a>
</div>
</body>
</html>
