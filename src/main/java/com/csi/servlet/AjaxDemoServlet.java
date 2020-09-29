package com.csi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "ajaxServlet",urlPatterns = "/ajax")
public class AjaxDemoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("您使用的是post请求");
        //接收数据
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String info = req.getParameter("info");
        System.out.println("接收的info是"+info);
        System.out.println("name:"+name+",password="+password);
        //返货响应信息给客户端
        PrintWriter out = resp.getWriter();
        //输出响应
        out.write("恭喜你你使用了post请求 很好");
        out.flush();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("您使用的是get请求");
        //处理编码方式
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        //接收用户信息
        String info = req.getParameter("info");
        System.out.println("接受的info是"+info);
        //返回响应信息给客户端
        PrintWriter out = resp.getWriter();
        //输出响应嘻嘻
        out.write("你个损色儿~~");
        out.flush();
    }
}
