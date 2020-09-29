<%@ page import="com.csi.dao.EmpDao" %>
<%@ page import="com.csi.dao.impl.EmpDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.csi.domin.Emp" %><%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/23
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        EmpDao dap = new EmpDaoImpl();
        List<Emp> emps = dap.selectAll();
        Map<String, Emp> map = new HashMap<>();
        for (Emp emp : emps) {
            map.put(emp.getEname(),emp);
        }
        request.setAttribute("map",map);
    %>
</head>
<body>
${requestScope.emp}<br>
${requestScope.emp.job}<br>
${requestScope.emp.empno}<br>
${requestScope.emp.ename}<br>
${requestScope.emp.dept}<br>
${requestScope.emp.getMgr}<br>
-------------------------------<br>
${requestScope.managerAll[2]}<br>
-------------------------------<br>
${map.JONES}<br>
${map.SCOTT}
<%--${requestScope.managerAll}<br>--%>
<%--${requestScope.deptAll}<br>--%>
</body>
</html>
