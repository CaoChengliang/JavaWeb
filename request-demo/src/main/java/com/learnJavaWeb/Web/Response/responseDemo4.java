package com.learnJavaWeb.Web.Response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 相应字节数据：设置相应字节相应体
 */
@WebServlet("/resp4")
public class responseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置输入流
        FileInputStream fis = new FileInputStream("D://微信图片_20230406093016.png");

        //2。获取输出流

        ServletOutputStream os = response.getOutputStream();
        //输入输出流的对考

//        byte[] buff = new byte[1024];
//        int length = 0;
//        while((length = fis.read(buff)) != -1){
//
//            os.write(buff,0,length);
//
//        }
        IOUtils.copy(fis,os);

        fis.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
