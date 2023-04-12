package com.learnJavaWeb.mapper;

import com.learnJavaWeb.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /**
     * g�����û���������в�ѯ�û�����
     * @param username
     * @param password
     * @return
     */
        @Select("select *  from tb_user where username = #{username} and password = #{password}")
        User select(@Param("username") String username,@Param("password") String password);

    /**
     * �����û������Ҷ���
     * @param username
     * @return
     */
        @Select("select  * from tb_user where username=#{username}")
        User selectByUsername(String username);
    /**
     * ��Ӷ���
     */
        @Insert("insert into tb_user values(null,#{username},#{password})")
        void add(User user);

}
