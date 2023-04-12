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
* mybatis快速入门
* */
public class MybatisDemo {
    public static void main(String[] args) throws Exception {
        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql

        List<User> users = sqlSession.selectList("test.selectAll");

        System.out.println(users);
        //shifan
        sqlSession.close();



    }

}
