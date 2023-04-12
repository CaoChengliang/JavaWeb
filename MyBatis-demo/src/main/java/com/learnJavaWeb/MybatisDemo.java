package com.learnJavaWeb;

import com.learnJavaWeb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/*
*
* mybatis��������
* */
public class MybatisDemo {
    public static void main(String[] args) throws Exception {
        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //ִ��sql

        List<User> users = sqlSession.selectList("test.selectAll");

        System.out.println(users);
        //shifan
        sqlSession.close();



    }

}
