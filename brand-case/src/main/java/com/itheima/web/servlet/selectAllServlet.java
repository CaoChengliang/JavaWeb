package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service_20211015_114634.BrandService;
import com.itheima.service_20211015_114634.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class selectAllServlet extends HttpServlet {
    private BrandService service = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = service.selectAll();

        String jsonString = JSON.toJSONString(brands);


        //设置相应头，防止中文乱码
        response.setContentType("text/json;charset = utf-8");

        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
