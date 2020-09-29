<%@ page import="java.util.UUID" %>
<%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/25
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
<%--    <%--%>
<%--       //生成一个随机的字符串 存储到session中--%>
<%--        session.setAttribute("word",UUID.randomUUID().toString());--%>
<%--    %>--%>
</head>
<body>
${message}
<form action="<%=application.getContextPath()%>/admin" method="post">
    <%--创建一个隐藏域--%>
    <input type="hidden" name="token" value="${word}">
    <input type="text" name="account" placeholder="请输入账号">
    <input type="password" name="password" placeholder="请输入密码">
    <input type="submit" value="登录">
</form>

</body>
</html>
