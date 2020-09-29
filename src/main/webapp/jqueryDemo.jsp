<%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/25
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="myForm" action="<%=application.getContextPath()%>/jquery" method="post">
    <input type="text" name="account" id="account" placeholder="请输入账号"><br>
    <input type="password" name="password" id="password" placaholder="请输入密码"><br>
    <input type="submit" value="登录">

</form>
</body>
</html>
