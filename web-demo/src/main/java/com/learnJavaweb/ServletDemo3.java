package com.learnJavaweb;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet(urlPatterns = "/demo3", loadOnStartup = 1)
public class ServletDemo3 implements Servlet {
    ServletConfig servletConfig;
    /**
     *   1.����ʱ����
     *      * Ĭ�ϵ�һ�η���Servletʱ���� ����ʹ��loadOnStartup = 1 ����������������ʱ
     *   2.���ô�����1
     * @param servletConfig
     * @throws ServletException
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("init......");
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Hello");
    }



    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }



    public String getServletInfo() {
        return "";
    }

    public void destroy() {
        System.out.println("destory!");
    }
}
