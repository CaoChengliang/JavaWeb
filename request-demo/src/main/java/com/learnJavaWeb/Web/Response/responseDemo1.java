package com.learnJavaWeb.Web.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class responseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("resp1....");

        /*
        * �ض��򣬿���Ͷ�䵽�ⲿ��Դ��
        * ��������
        * ��ַ����ת��
        *
        * ·�����⣺
        * ������������ʵľ�����Ҫ������Ŀ¼
        * �������ڲ����ʵľͲ�������Ŀ¼
        *
        * ����ʹ��request ��request.getContextPath()��������̬��ȡ�����ַ�����ʹ������
        * */

        //�ɷ���
//        response.setStatus(302);
//        response.setHeader("location","/request-demo/resp2");

        //�·���
        //response.sendRedirect("https://www.baidu.com");

        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/resp2");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
