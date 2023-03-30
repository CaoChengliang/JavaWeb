package com.learnJavaWeb.JDBCDemo;

import com.learnJavaWeb.JDBCDemo.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
* JDBC API Statement
* */
public class JDBC_demo6_UserLogin {


/*
*
* 演示sql注入
* */
    @Test
    public void TestResult2() throws Exception {
        //1.注册驱动可以不用写了
        //Class.forName("com.mysql.jdbc.Driver");


        //创建链接

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password= "1234";
        Connection conn = DriverManager.getConnection(url, user, password);
        //sql注入
        String username= "zhagsan";
        String pwd = "' or '1' = '1";

        String sql = "select * from tb_user where username ='"+username+"' and password = '"+pwd+"'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        if(rs.next()){
            System.out.println("1登陆成功");
        }else{
            System.out.println("2登陆失败");
        }

        rs.close();
        stmt.close();
        conn.close();

    }
}
