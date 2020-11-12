<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/10/24
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<div style="color:red ; font:25px bolder ; text-align:center;">
    <%String s =(String)request.getAttribute( "ValueA ");
        if (s==null) s="";%>
    <%=s%>
</div>
<hr>
<div style="text-align:center;margin-top: 120px">
    <form action="ChangeServlet" method="post">
        <table style="margin-left:40%">
            <caption>修改密码</caption>
            <tr>
                <td>登录名：</td>
                <td><input name="username" type="text" size="20"></td>
            </tr>
            <tr>
                <td>旧密码:</td>
                <td><input name="oldPassword" type="password" size="20"></td>
            </tr>
            <tr>
                <td>新密码:</td>
                <td><input name="password" type="password" size="20"></td>
            </tr>
            <tr>
                <td>重复新密码:</td>
                <td><input name="passwordrp" type="password" size="20"></td>
            </tr>
        </table>
        <input type="submit" value="修改">
        <input type="reset" value="重置">
    </form>
    <br>
    <a href="Login.jsp">登录</a>
    </form>
</div>

</body>
</html>
