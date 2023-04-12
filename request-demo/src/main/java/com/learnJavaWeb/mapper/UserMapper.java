package com.learnJavaWeb.mapper;

import com.learnJavaWeb.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /**
     * g根据用户名密码进行查询用户对象
     * @param username
     * @param password
     * @return
     */
        @Select("select *  from tb_user where username = #{username} and password = #{password}")
        User select(@Param("username") String username,@Param("password") String password);

    /**
     * 根据用户名查找对象
     * @param username
     * @return
     */
        @Select("select  * from tb_user where username=#{username}")
        User selectByUsername(String username);
    /**
     * 添加对象
     */
        @Insert("insert into tb_user values(null,#{username},#{password})")
        void add(User user);

}
