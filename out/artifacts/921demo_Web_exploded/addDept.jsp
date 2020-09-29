<%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/21
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
    <script>
        $(function () {
            $("#deptno").blur(function () {
                $.ajax({
                    url: "<%=application.getContextPath()%>/dept?op=jax",
                    type: "post",
                    data: {
                        "deptno": $("#deptno").val()
                    },
                    success: function (data) {
                        console.log(data);
                        if (data == "1") {
                            $("#showDeptno").text("对不起，该编号已经存在无法进行注册").css("color", "red");
                        } else {
                            $("#showDeptno").text("该编号可用").css("color", "green");
                        }
                    },
                    error: function (e) {
                        alert(e);
                    }
                });
            });


    </script>

</head>
<body>
<%@include file="header.jsp"%>
<form action="<%=application.getContextPath()%>/dept?op=addDept" method="post">
    <input type="text" name="deptno" placeholder="请输入部门编号"></br>
    <input type="text" name="dname" placeholder="请输入部门名称"></br>
    <input type="text" name="loc" placeholder="请输入部门地点"></br>
    <input type="submit" value="添加部门">

</form>
</body>
</html>
