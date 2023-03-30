package com.learnJavaWeb.JDBCDemo;

import org.junit.Test;

import java.sql.*;

/*
* JDBC API Statement
* */
public class JDBC_demo7_PrepareStatment {


/*
*
* 演示Preparestament 防止sql注入
* */
    @Test
    public void TestPreparestatment() throws Exception {
        //1.注册驱动可以不用写了
        //Class.forName("com.mysql.jdbc.Driver");


        //创建链接

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password= "1234";
        Connection conn = DriverManager.getConnection(url, user, password);
        //sql注入
        String username= "zhangsan";
        String pwd = "123";

        //sql语句
        String sql = "select * from tb_user where username = ? and password = ?";

        //写preparestatment

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,username);
        pstmt.setString(2,pwd);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            System.out.println("1登陆成功");
        }else{
            System.out.println("2登陆失败");
        }

        rs.close();
        pstmt.close();
        conn.close();

    }
}
