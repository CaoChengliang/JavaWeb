package com.learnJavaWeb.Web.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * 中文乱码解决方法
 *
 */
@WebServlet("/req1")
public class requestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //POST :设置输入流的字符编码
        //request.setCharacterEncoding("UTF-8");


        String username = request.getParameter("username");

        System.out.println("解决乱马前"+username);

        //GET的中文设置方式，
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);

        username = new String(bytes,StandardCharsets.UTF_8);

        System.out.println("解决乱马猴"+username);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
