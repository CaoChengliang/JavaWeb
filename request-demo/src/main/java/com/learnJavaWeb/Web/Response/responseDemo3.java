package com.learnJavaWeb.Web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ��Ӧ�ַ����ݣ�������Ӧ�ַ���Ӧ��
 */
@WebServlet("/resp3")
public class responseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //�����õ����ʻ�����
        response.setContentType("text/html;charset=utf-8");

        //��ȡ�ַ�������
        PrintWriter writer = response.getWriter();
        //������Ӧ�����������ʽ��

       // response.setHeader("content-type","text/html");
        //д��
        writer.write("aaa00");
        writer.write("����");
        writer.write("<h1>aaa<h2>");

        //ϸ�ڣ� ������Ҫ�ر�
        //Ҫ��������ı����������ı����ʽΪutf-8


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
