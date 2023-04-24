package com.creatAccountApp.service;

import com.creatAccountApp.mapper.UserMapper;
import com.creatAccountApp.pojo.User;
import com.creatAccountApp.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService{

    SqlSessionFactory factory  = SqlSessionFactoryUtils.getSqlSessionFactory();

    //登陆
    @Override
    public User login(String UserName, String PasswordHash) {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(UserName, PasswordHash);

        sqlSession.close();
        return user;

    }
}
