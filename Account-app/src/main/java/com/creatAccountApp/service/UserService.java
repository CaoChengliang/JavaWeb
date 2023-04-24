package com.creatAccountApp.service;

import com.creatAccountApp.pojo.User;

public interface UserService {

    /**
     * 用户登录
     * @param UserName
     * @param PasswordHash
     * @return
     */
    User login(String UserName,String PasswordHash);

}
