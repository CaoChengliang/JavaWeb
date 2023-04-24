package com.creatAccountApp.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * �滻HttpServlet,������������һ��·��
 *
 */

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String uri = req.getRequestURI();

        int index = uri.lastIndexOf('/');

        String methodName = uri.substring(index + 1); //��Ϊ �س����ġ��ַ���������/��

        Class<? extends BaseServlet> cls = this.getClass();

        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
