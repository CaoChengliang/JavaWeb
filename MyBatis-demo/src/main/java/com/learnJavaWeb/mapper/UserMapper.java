package com.learnJavaWeb.mapper;

import com.learnJavaWeb.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();
    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);
}
