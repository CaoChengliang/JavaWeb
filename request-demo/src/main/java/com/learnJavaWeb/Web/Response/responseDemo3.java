package com.learnJavaWeb.Web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 相应字符数据：设置相应字符相应体
 */
@WebServlet("/resp3")
public class responseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //不设置的中问会乱码
        response.setContentType("text/html;charset=utf-8");

        //获取字符输入流
        PrintWriter writer = response.getWriter();
        //设置相应浏览器解析格式，

       // response.setHeader("content-type","text/html");
        //写入
        writer.write("aaa00");
        writer.write("中文");
        writer.write("<h1>aaa<h2>");

        //细节： 流不需要关闭
        //要想解析中文必须设置流的编码格式为utf-8


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
