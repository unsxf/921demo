package com.csi.servlet;

import com.csi.domin.Dept;
import com.csi.service.DeptService;
import com.csi.service.Impl.DeptServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "deptServlet",urlPatterns = "/dept")
public class DeptServlet extends HttpServlet {
  private void ajax(HttpServletRequest req, HttpServletResponse resp)throws IOException{
//      //接收请求参数数据
//      String deptno = req.getParameter("deptno");
//      String dname = req.getParameter("dname");
//      //创建输出流对象
//      PrintWriter out = resp.getWriter();
//      if (deptno !=null){
//          Dept d = this.service.findById(deptno);
//          //如果要是有数据返回1没有数据返回0
//          out.write(d !=null?"1":"0");
//          out.flush();
//      }else if (dname!=null){
//         Dept d = this.service.FindByName(dname);
//         //如果要是有数据返回1没有数据返回0
//          out.write(d!=null?"1":"0");
//          out.flush();
//      }

  }

}
