package com.itheima.web.servlet;


import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service_20211015_114634.BrandService;
import com.itheima.service_20211015_114634.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. ����service��ѯ
        List<Brand> brands = brandService.selectAll();

        //2. תΪJSON
        String jsonString = JSON.toJSONString(brands);
        //3. д����
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. ����Ʒ������
        BufferedReader br = request.getReader();
        String params = br.readLine();//json�ַ���

        //תΪBrand����
        Brand brand = JSON.parseObject(params, Brand.class);

        //2. ����service���
        brandService.add(brand);

        //3. ��Ӧ�ɹ��ı�ʶ
        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1. ����Ʒ������
        BufferedReader br = request.getReader();
        String params = br.readLine();//json�ַ���

        //תΪBrand����
        Brand brand = JSON.parseObject(params, Brand.class);

        //2. ����service���
        brandService.update(brand);

        //3. ��Ӧ�ɹ��ı�ʶ
        response.getWriter().write("success");


    }

    public void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String id = request.getParameter("id");

        Brand brand = brandService.selectById(Integer.parseInt(id));

        //2. תΪJSON
        String jsonString = JSON.toJSONString(brand);
        //3. д����
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);



    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1. ����id����
        BufferedReader br = request.getReader();
        String id = br.readLine();//json�ַ���

        brandService.deleteById(Integer.parseInt(id));


        response.getWriter().write("success");

    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1. ����id����
        BufferedReader br = request.getReader();
        String params = br.readLine();//json�ַ���

        int[] ids = JSON.parseObject(params, int[].class);

        System.out.println(ids);

        brandService.deleteByIds(ids);


        response.getWriter().write("success");

    }

    /**
     * ��ҳ��ѯ
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.���ղ���
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);



        //2. תΪJSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. д����
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1.���ղ���
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        BufferedReader br = request.getReader();
        String params = br.readLine();//json�ַ���


        Brand brand = JSON.parseObject(params, Brand.class);
        //System.out.println(brand);
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);
        System.out.println(pageBean.getRows());


        //2. תΪJSON
        String jsonString = JSON.toJSONString(pageBean);

        //3. д����
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

}
