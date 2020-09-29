<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.csi.domin.Dept" %>
<%@ page import="java.util.List" %>
<%@ page import="com.csi.domin.Emp" %>
<%@ page import="com.csi.DBUtil.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/21
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有员工信息</title>
    <%
       List<Emp> all = (List<Emp>) request.getAttribute("all");
    %>
    <style>
        table{
            margin: auto;
            text-align: center;
            border-collapse:collapse;
        }
        table,th,td{
            border: 1px solid black;
        }
    </style>
    <script>
        $(function () {
            /*获取删除按钮绑定单击事件*/
            $(".delClass").click(function (event) {
                //让超链接失效
                event.preventDefault();
                //弹出一个缺人弹窗
                if (confirm("是否缺人删除？")){
                    //确认删除
                    window.location.href=$(this).attr("href");
                }else{
                    alert("删除操作取消")
                }

            });

        })
    </script>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>职位</th>
        <th>领导编号</th>
        <th>入职日期</th>
        <th>薪资</th>
        <th>提成</th>
        <th>部门</th>
        <th>操作</th>
    </tr>
<%--    <%--%>
<%--        for (Emp e:all){--%>
<%--            String t = DateFormat.dateToString(e.getHiredate());--%>
<%--            String comm = e.getComm()!=null?e.getComm() + "" : "无提成";--%>
<%--    %>--%>
    <c:forEach items="${all}" var="e">
    <tr>
<%--        <td><%=e.getEmpno()%></td>--%>
<%--        <td><%=e.getEname()%></td>--%>
<%--        <td><%=e.getJob()%></td>--%>
<%--        <td><%=e.getMgr()%></td>--%>
<%--        <td><%=t%></td>--%>
<%--        <td><%=e.getSal()%></td>--%>
<%--        <td><%=comm%></td>--%>
<%--        <td><%=e.getDept().getDeptno()%></td>--%>
        <td>${e.empno}</td>
        <td>${e.ename}</td>
        <td>${e.job}</td>
        <td>${e.mgr}</td>
        <td>${e.hiredate}</td>
        <td>${e.sal}</td>
        <td><c:out value="${e.comm}" default="无提成" /></td>
        <td>${e.dept.dname}</td>
        <td>
            <a href="<%= application.getContextPath()%>/emp?opfindById&empno=${e.empno}"><button>编辑</button></a>

            <a class="delClass" href="<%= application.getContextPath()%>/emp?remove&empno=${e.empno}%>"><button>编辑</button></a>
        </td>

    </tr>
    </c:forEach>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>

</table>
</body>
</html>
