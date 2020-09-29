<%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/25
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json对象创建以及打印</title>
    <script src="js/jquery-1.11.3.min.js"></script>
    <script>
        //这些代码都是javvascript代码 不能使用session EL
        /*创建一个对象 进行数据的存储*/
        var user={"id":1,"username":"张三","password":"000"};
        /*创建一个数组*/
        var arr=["中","美","俄"];
        /*创建一个json格式的对象数组*/
        var users=[
            {"id":1001,"username":"李铁蛋","password":"116"},
            {"id":1002,"username":"大钢蛋","password":"118"},
            {"id":1003,"username":"小刚蛋","password":"367"}
        ];
        $(function () {
            $("#id").text(user.id);
            $("#name").text(user.username);
            $("#password").text(user.password);
            /*遍历arr*/
            $.each(arr, function (inndex,obj){
                $("#myU1").append("<li>"+obj+"</li>");
                $("#mySelect").append("<option value='"+obj+"'>"+obj+"</option>");
            });
            /*遍历users*/
            $.each(users, function(index,obj){//obj其实就是便利的对象user
                $("#myTb").append("<tr>"+
                "<td>"+obj.id+"</td>"+
                "<td>"+obj.username+"</td>"+
                "<td>"+obj.password+"</td>"+
                "</tr>");
            })
        })

    </script>
    <style>
        table{
            width: 300px;
            border-collapse: collapse;
            text-align: center;
        }
        table,td,th{
            border: 1px solid black;
        }
    </style>
</head>
<body>
一 、json对象输出<br>
ID:<span id="id"></span><br>
用户名称:<span id="name"></span><br>
密码:<span id="password"></span><br>
二、json格式字符串输出<br>
<ul id="muU1">

</ul>
<select id="muSelect">

</select><br>
三、输出json对象的user数组对象<br>
<table id="myTb">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
    </tr>
</table>
</body>
</html>
