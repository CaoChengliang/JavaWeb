package com.creatAccountApp.mapper;

import com.creatAccountApp.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where UserName = #{UserName} and PasswordHash = #{PasswordHash}")
    User select(@Param("UserName") String UserName, @Param("PasswordHash") String PasswordHash);

}
