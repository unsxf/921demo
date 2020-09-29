<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax的post请求案例</title>
    <script>
        //创建XmlHttpRequest对象的一个全局变量
        var xhr;
        /*当浏览器加载完毕之后调用函数*/
        window.onload = function (ev) {
            /*获取按钮元素 绑定一个鼠标单击事件调用函数*/
            document.getElementById("btn").onclick=function(ev1){
                //获取文本框内数据
                var info = document.getElementById("info").value();
                //alert(info);
                /*获取xmlHttprequest对象*/
                if (window.XMLHttpRequest){//判断浏览器是否支持xmlHttprequest对象
                    xhr = new XMLHttpRequest();
                }else{//使用旧版本进行兼容
                    xhr=new ActiveXObject("Mirosoft.XMLHTTP")
                }
                //给xhr绑定回调函数
                xhr.onreadystatechange=callback;
                //获取连接 是否开启异步通信
                xhr.open("post","<%=application.getContextPath()%>/ajax",true);
                //设置请求头信息
                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                //发送消息给服务器
                xhr.send("name=zhangsan&password=123456&info="+info);
            }
        }
        //回调函数进行响应处理
        function callback(){
            //判断状态信息 是否已经获取完毕响应信息
            if (xhr.readyState == 4){
                /*判断http的状态码*/
                if (xhr.status == 200){
                    //证明响应获取完毕一切正常 可以获取相应信息了
                    var s = xhr.responseText;
                    document.getElementById("myDiv").innerHTML=s;
                }
            }
        }
    </script>
</head>
<body>
<input type="text" name="info"id="info">
<button id="btn">我是按钮</button>
<div id="myDiv">我是一个div</div>
<form action="" method="" enctype="application/x-www-form-urlencoded"></form>
</body>
</html>
