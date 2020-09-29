package com.csi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
@WebServlet(name = "jqueryServlet",urlPatterns = "/admin")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应的编码等类型信息
        resp.setContentType("text/html;charset=UTF-8");
        //获取输出对象
        PrintWriter out = resp.getWriter();
        out.println(LocalDateTime.now()+"这是后台传递的时间哈哈哈哈");
        out.flush();
        out.close();
        while (true){
            System.out.println("持续打印中。。。。好刺激。。。。");
        }
    }
}
