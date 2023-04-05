package com.learnJavaWeb.test;

import com.learnJavaWeb.mapper.UserMapper;
import com.learnJavaWeb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {


    @Test
    public void testSelectByIdAnnoction() throws IOException {
        int id = 1;

        //½¨Á¢Á´½Ó
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

        User user = usermapper.selectById(id);

        System.out.println(user);

        sqlSession.close();

    }
}
