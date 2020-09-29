<%@ page import="com.csi.dao.EmpDao" %>
<%@ page import="com.csi.dao.impl.EmpDaoImpl" %>
<%@ page import="com.csi.domin.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/24
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <%
        EmpDao dao = new EmpDaoImpl();
        List<Emp> emps = dao.selectAll();
        Map<String,Emp> map = new HashMap<>();
        for (Emp emp : emps) {
            map.put(emp.getEname(),emp);
        }
        request.setAttribute("map",map);
    %>
</head>
<body>
<c:forEach items="${map}" var="m" varStatus="status">
    <p <c:if test="${status.index %2 == 0}"> style="background-color: aquamarine;"</c:if>>${m.key}----------${m.value}</p>
</c:forEach>
</body>
</html>
