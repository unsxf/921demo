<%@ page import="com.csi.dao.EmpDao" %>
<%@ page import="com.csi.dao.impl.EmpDaoImpl" %>
<%@ page import="com.csi.domin.Emp" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" url="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
       EmpDao dap = new EmpDaoImpl();
       Emp emp = dap.selectByIdAndName(7788,"SCOTT");
       //将emp对象存储到请求属性中
        request.setAttribute("emp",emp);
    %>
</head>
<body>
<c:set var="account" value="tivon" scope="request"/>
${requestScope.account}
<br>
修改之前的内容是:${emp}<br>
<c:set target="${emp}" property="ename" value="钢琴"/>
修改之后的内容是:${emp}<br>

-----------------------------------以下内容使用out标签进行输出<br>
<c:out value="${emp.ename}"/>------
<c:out value="${emp.sal}"/>--------
<c:out value="${emp.comm}" default="无提成"/>------<br>
-----------------------------------以下内容使用out标签进行输出百度<br>
<p>${"<a href='http://www.baidu.com'>百度</a>"}</p><%--自动进行解析 超链接--%>
<p><c:out escapeXml="false" value="<a href='http://www.baidu.com'>百度</a>"></c:out> </p><%--自动进行解析 超链接--%>
<p><c:out value="<a href='http://www.baidu.com'>百度</a>"></c:out> </p><%--没有解析超链接标签 直接进行文本输出--%>
</body>
</html>
