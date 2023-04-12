package com.learnJavaweb;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/demo6")
public class ServletDemo6 extends myHttpServlet{

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("Post.....");
    }

    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("GET......");
    }
}
