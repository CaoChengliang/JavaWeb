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
        //�����û�����
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        //��װ�û�����
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //��ȡSqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //��ȡmapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //�����û�����
        User u = userMapper.selectByUsername(username);

        response.setContentType("text/html;charset=utf-8");
        //�ж��Ƿ�Ϊnull
        if(u == null){
            //�û�������
            userMapper.add(user);

            sqlSession.commit();

            sqlSession.close();

            response.getWriter().write("ע��ɹ�");
        }else{

            response.getWriter().write("ע��ʧ�ܣ��û��Ѵ���");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
