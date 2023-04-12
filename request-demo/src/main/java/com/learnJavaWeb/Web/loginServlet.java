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

        //2.����mybatis

        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //��ȡSqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //��ȡmapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //���÷���
        User user = userMapper.select(username, password);

        //�ͷ���Դ
        sqlSession.close();
        
        //��ȡ�ַ�����������ñ���
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //�ж��Ƿ�Ϊnull
        if (user != null){

            writer.write("��½�ɹ�");

        }else{

            writer.write("��½ʧ��");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
