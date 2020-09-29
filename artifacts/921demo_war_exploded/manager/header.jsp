<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   Object admin = session.getAttribute("admin");
   if (admin == null){
      request.setAttribute("message","对不起 您还没有登陆 无法直接访问 请先进行登陆操作");
      request.getRequestDispatcher("login.jsp").forward(request,response);

    }
%>
<div style="margin: auto; text-align: center">
    <a href="<%=application.getContextPath()%>/ifDemo.jsp">添加类别</a>
    <a href="#">查询类别</a>
    <a href="<%=application.getContextPath()%>/dept?op=findAll">显示所有类别</a>
    <%--点击添加员工跳转到一个servlet帮助我们查询所有的员工领导以及所有部门信息显示到jsp界面
    用于客户进行选择--%>
    <a href="<%=application.getContextPath()%>emp?op=addFind">添加员工信息</a>
    <a href="<%=application.getContextPath()%>emp?op=findAll">显示所有员工信息 </a>

    <c:if test="${empty sessionScope.admin}">
        <a href="<%=application.getContextPath()%>/login.jsp"><button>登陆</button></a>
    </c:if>
    <c:if test="${!empty sessionScope.admin}">
        ${admin.name}
        <a href="<%=application.getContextPath()%>/admin?op=reset">注销</a>
    </c:if>
    当前已访问的人数是:${applicationScope.num}
</div>