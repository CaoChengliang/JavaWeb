package com.learnJavaWeb.Web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req")
public class requestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // System.out.println("get......");

        Map<String, String[]> map = req.getParameterMap();

        for (String key : map.keySet()) {
            System.out.print(key + ":");

            String[] values = map.get(key);

            for (String value : values) {

                System.out.print(value + " ");

            }

            System.out.println();

        }

        System.out.println("--------------------");

        //根据key获取参数值

        String[] hobbies = req.getParameterValues("hobby");

        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //根据key获取单个值

        String username = req.getParameter("username");
        String password = req.getParameter("wpassword");

        System.out.println(username+ " "+ password);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                this.doGet(req,resp);

    }
}
