package com.learnJavaweb;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet(urlPatterns = "/demo2", loadOnStartup = 1)
public class ServletDemo2 implements Servlet {

    /**
     *   1.调用时机：
     *      * 默认第一次访问Servlet时调用 可以使用loadOnStartup = 1 来设置启动服务器时
     *   2.调用次数：1
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
