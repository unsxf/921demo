package com.csi.servlet;

import com.csi.domin.Goods;
import com.csi.service.GoodsService;
import com.csi.service.Impl.GoodsServiceImpl;
import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_zh_TW;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
@WebServlet(name = "goodsServlet",urlPatterns = "/goods")
/*添加一个支持文件上传的注解*/
@MultipartConfig
public class GoodsServlet extends HttpServlet {
    private GoodsService service;
    public GoodsServlet() {
        this.service = new GoodsServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException{
        doPost(request, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if ("add".equals(op)){
            this.add(req, resp);
        }else if("findAll".equals(op)){
            try {
                this.findAll(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Goods> all = this.service.findAll();
        request.setAttribute("all",all);
        request.getRequestDispatcher("showAllGoods.jsp").forward(request, resp);
    }

    private void add(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
        //获取名称以及价格文本数据
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        //获取图片part对象
        Part part = request.getPart("img");
        //获取提交图片名称
        String oldName = part.getSubmittedFileName();
        //给图片起一个新图片名称
        String newName="/"+
                UUID.randomUUID().toString().replaceAll("-","").toUpperCase()
                +oldName.substring(oldName.lastIndexOf("."));
        //找到文件存储到位置 获取项目运行的本地路径
        String path=this.getServletContext().getRealPath("/upload");
        //创建一个文件对象
        File f = new File(path);
        //判断文件是否存在
        if (!f.exists()){
            //创建文件夹
            f.mkdir();
        }
        //利用part接口进行图片上传
        part.write(path+newName);
        String s = this.service.addGoods(new Goods(1,name,"/upload"+newName,Double.valueOf(price)));
        System.out.println(s);
        resp.sendRedirect("addGoods.jsp");
    }

}
