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
        * 重定向，可以投射到外部资源。
        * 两次请求
        * 地址发生转换
        *
        * 路径问题：
        * 对于浏览器访问的就是需要加虚拟目录
        * 服务器内部访问的就不加虚拟目录
        *
        * 可以使用request 的request.getContextPath()方法来动态获取虚拟地址，降低代码耦合
        * */

        //旧方法
//        response.setStatus(302);
//        response.setHeader("location","/request-demo/resp2");

        //新方法
        //response.sendRedirect("https://www.baidu.com");

        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/resp2");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
