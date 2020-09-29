package com.csi.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter(filterName = "characterFilter",urlPatterns = "/*",initParams = {
        @WebInitParam(name="character",value = "utf-8")
})
public class CharacterFilter implements Filter {
    //创建一个私有的属性编码方式
    private String character;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("这是过滤器的初始化方法");
        //利用config对象获取初始化参数
        this.character = filterConfig.getInitParameter("character");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("这是过滤器的过滤方法");
        servletRequest.setCharacterEncoding(this.character);
        servletResponse.setCharacterEncoding(this.character);
        this.getAddress((HttpServletRequest)servletRequest);//如果不是本网站访问 可以跳转到其他界面或者资环
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //创建一个方法用于判断是否是同一个ip发起请求
    private boolean getAddress(HttpServletRequest servletRequest) {
        //获取项目路径
        String path = servletRequest.getContextPath();
        //拼接一个url地址
        String url=servletRequest.getScheme()+"://"+servletRequest.getServerName()+":"+servletRequest.getServerPort()+path;
        System.out.println(url);
        String referer = servletRequest.getHeader("referer");
        System.out.println(referer);
        return referer!=null && referer.startsWith(url);
    }


    @Override
    public void destroy() {
        System.out.println("这是过滤器销毁方法");

    }
}
