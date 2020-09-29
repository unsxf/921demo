package com.csi.listener;

import com.csi.DBUtil.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.*;
@WebListener("VisitCountListener")
public class VisitCountListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.println("服务器启动了，context对象被创建了，开始运行");
        //读取数据库中的count表数据
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select num from count");
        ResultSet rs = DBUtil.query(pstmt);
        //创建一个临时变量用于存储读取的数值
        int num = 0;
        try {
            if (rs.next()){
                num=rs.getInt("num");
            }
                //将num数值存储到全局变量中
                ServletContext sc = servletContextEvent.getServletContext();
                        sc.setAttribute("num",num);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
        System.out.println("服务器正在关闭，context正在被销毁");
        //读取数据库中count表数据
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"update count set num =?",
                (int)servletContextEvent.getServletContext().getAttribute("num"));
        DBUtil.update(pstmt);
    }
}
