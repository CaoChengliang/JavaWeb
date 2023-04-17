package com.learnJavaWeb.Web.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * ��������������
 *
 */
@WebServlet("/req1")
public class requestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //POST :�������������ַ�����
        //request.setCharacterEncoding("UTF-8");


        String username = request.getParameter("username");

        System.out.println("�������ǰ"+username);

        //GET���������÷�ʽ��
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);

        username = new String(bytes,StandardCharsets.UTF_8);

        System.out.println("��������"+username);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
