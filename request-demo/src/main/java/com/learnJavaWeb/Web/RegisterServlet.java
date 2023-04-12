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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //接收用户数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        //封装用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //获取Sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //查找用户对象
        User u = userMapper.selectByUsername(username);

        response.setContentType("text/html;charset=utf-8");
        //判断是否为null
        if(u == null){
            //用户不存在
            userMapper.add(user);

            sqlSession.commit();

            sqlSession.close();

            response.getWriter().write("注册成功");
        }else{

            response.getWriter().write("注册失败，用户已存在");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
