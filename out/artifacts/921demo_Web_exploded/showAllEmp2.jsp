<%@ page import="com.csi.domin.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.csi.DBUtil.DateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有员工信息</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
    <style>
        table{
            margin: auto;
            text-align: center;
            border-collapse: collapse;
        }
        table,th,td{
            border: 1px solid #000000;
        }
    </style>
    <script>
        $(function () {
            /*获取删除按钮绑定单击事件*/
            $(".delClass").click(function (event) {
             //让超链接失效
                event.preventDefault();
                //弹出一个确认弹框
                if (confirm("是否确认删除？")){
                    //确认删除
                    window.location.href=$(this).attr("href");
                }else {
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
    <c:forEach items="${empPage.data}" var="e">
        <tr>
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

                <a class="delClass" href="<%= application.getContextPath()%>/emp?remove&empno=${e.empno}%>"><button>删除</button></a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="9" style="border: black">
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=1">首页 </a>
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=${empPage.prev()}">上一页</a>
            当前页 ${empPage.currentPage}/${empPage.getTotalPageCount()}
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=${empPage.next()}">下一页</a>
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=${empPage.getTotalPageCount()}">尾页</a>
        </td>
    </tr>
</table>
</body>
</html>
