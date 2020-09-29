package com.csi.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csi.dao.EmpDao;
import com.csi.dao.impl.EmpDaoImpl;
import com.csi.domin.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "jqueryServlet",urlPatterns = "/jquery")
public class JqueryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理编码方式
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        super.service(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("您进入了get请求");
//        PrintWriter out = resp.getWriter();
//        out.write("哈哈哈哈哈 ajax请求成功 你是真get");
//        out.flush();
        EmpDao dao = new EmpDaoImpl();
        List<Emp> emps = null;
        try {
            emps = dao.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String s = JSON.toJSONString(emps, SerializerFeature.WriteNullNumberAsZero,SerializerFeature.PrettyFormat);
        PrintWriter out = resp.getWriter();
        out.write(s);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        System.out.println("接受的数据是:"+account+"-----"+password);
        PrintWriter out = resp.getWriter();
        out.write("哈哈哈哈哈 ajaxx请求成功 你是post");
        out.flush();
    }
}
