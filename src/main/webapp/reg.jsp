<%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/23
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<form method="post" action="object.jsp">
    <input type="text" name="account" placeholder="请输入用户名"><br>
    <input type="password" name="password" placeholder="请输入密码"><br>
    爱好:
    <input type="checkbox" name="hobby" value="足球">足球
    <input type="checkbox" name="hobby" value="排球">排球
    <input type="checkbox" name="hobby" value="篮球">篮球
    <input type="checkbox" name="hobby" value="玻璃球">玻璃球
    <br>
    <input type="submit" value="注册">
</form>
</body>
</html>
