package com.learnJavaWeb.Web;

import com.learnJavaWeb.Util.SqlSessionFactoryUtils;
import com.learnJavaWeb.mapper.UserMapper;
import com.learnJavaWeb.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用mybatis

        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //获取Sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User user = userMapper.select(username, password);

        //释放资源
        sqlSession.close();
        
        //获取字符输出流并设置编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //判断是否为null
        if (user != null){

            writer.write("登陆成功");

        }else{

            writer.write("登陆失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
