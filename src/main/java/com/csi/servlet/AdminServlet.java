package com.csi.servlet;

import com.csi.domin.Admin;
import com.csi.service.AdminService;
import com.csi.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "adminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private AdminService service;
    public AdminServlet(){
        this.service = new AdminServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       //获取账号和密码
        req.setCharacterEncoding("utf-8");
        String op = req.getParameter("op");
        if ("login".equals(op)){
            this.login(req,resp);
        }else if ("reset".equals(op)){
            this.reset(req,resp);
        }
    }

    private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("admin");
        req.setAttribute("message","注销成功，请重新登陆");
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        Admin admin = this.service.login(account,password);
        if (admin == null){
            req.setAttribute("message","对不起，登陆失败，请重新登陆");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            //将用户信息存储到session中
            HttpSession session = req.getSession();
            session.setAttribute("admin",admin);
            //只要是登陆成功就证明有人登陆了 我们就需要把登陆的人数记录到全局变量servlet对象中
            int num = (int) this.getServletContext().getAttribute("num");
            //将数值+1 再存储到全局变量中
            this.getServletContext().setAttribute("num",num+1);
            resp.sendRedirect("index.jsp");
        }
    }


}
