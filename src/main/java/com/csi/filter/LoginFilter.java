package com.csi.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.IOException;
@WebFilter(filterName = "loginFilter",urlPatterns = "/manager/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        //通过request对象获取session
        HttpSession session = request.getSession();
        //获取session中的数据
        Object admin = session.getAttribute("admin");
        if (admin == null){//直接访问admin/下面的内容 直接跳转到Login.jsp 有可能是在admin目录下进行查询
            request.setAttribute("message","对不起，你你还没有登录，无法直接访问，请先进行登录操作");
            request.getRequestDispatcher("../login.jsp").forward(request,servletResponse);
        }
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
