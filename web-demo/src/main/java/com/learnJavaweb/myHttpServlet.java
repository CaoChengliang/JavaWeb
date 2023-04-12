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

        //根据请求方式不用，进行分别处理

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //获取请求方式
        String method = request.getMethod();

        //判断
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
