<%@ page import="com.csi.domin.Emp"%>
<%@ page import="com.csi.dao.EmpDao"%>
<%@ page import="com.csi.dao.impl.EmpDaoImpl"%>%
<%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/24
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <%
       EmpDao dao = new EmpDaoImpl();
       Emp emp = dao.selectByIdAndName(7788,"SCOTT");
       //不存储到session中
        session.setAttribute("emp",emp);

    %>
</head>
<body>
<c:choose>
    <c:when test="${emp.dept.deptno == 10}">是10号部门</c:when>
    <c:when test="${emp.dept.deptno == 20}">是20号部门</c:when>
    <c:when test="${emp.dept.deptno == 30}">是30号部门</c:when>
    <c:when test="${emp.dept.deptno == 40}">是40号部门</c:when>
    <c:otherwise>不是10,20,30,40号部门</c:otherwise>

</c:choose>
<c:set var="isLogin" value="${emp.ename ne null}"/>
<c:if test="${isLogin}">
    欢迎 【${emp.ename}】访问此网站
</c:if>
<c:if test="${!isLogin}">
    对不起 您还没有登录
</c:if>
</body>
</html>
