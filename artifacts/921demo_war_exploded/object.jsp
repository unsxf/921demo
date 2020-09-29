<%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/23
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
       pageContext.setAttribute("info","这是一条信息1");
       request.setAttribute("info","这是一条信息2");
       session.setAttribute("info","这是一条信息3");
       application.setAttribute("info","这是一条信息4");
       request.setCharacterEncoding("utf-8");
    %>
</head>
<body>
${pageScope.info}-----
${requestScope.info}------
${info}<br>

${param.accout}-----
${param.password}------
${paramValues.hobby[0]}------
${pageContext.servletContext.getInitParameter("encoding")}-----
</body>
</html>
