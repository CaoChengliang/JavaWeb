package com.learnJavaweb;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class myHttpServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //��������ʽ���ã����зֱ���

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //��ȡ����ʽ
        String method = request.getMethod();

        //�ж�
        if("GET".equals(method)){
            doGet(servletRequest,servletResponse);
        }else if("POST".equals(method)){

            doPost(servletRequest,servletResponse);
        }



    }

   protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
    }
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
