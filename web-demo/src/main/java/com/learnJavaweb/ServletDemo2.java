package com.learnJavaweb;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet(urlPatterns = "/demo2", loadOnStartup = 1)
public class ServletDemo2 implements Servlet {

    /**
     *   1.����ʱ����
     *      * Ĭ�ϵ�һ�η���Servletʱ���� ����ʹ��loadOnStartup = 1 ����������������ʱ
     *   2.���ô�����1
     * @param servletConfig
     * @throws ServletException
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Hello");
    }



    public ServletConfig getServletConfig() {
        return null;
    }



    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destory!");
    }
}
