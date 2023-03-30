package com.learnJavaWeb.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_demo {

    public static void main(String[] args) throws Exception {
        //1.注册驱动可以不用写了
        //Class.forName("com.mysql.jdbc.Driver");


        //创建链接

        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String user = "root";
        String password= "1234";
        Connection con = DriverManager.getConnection(url, user, password);

        //定义sql语句
        String sql = "update account set money = 2000 where id = 2";

        //获取执行对象
        Statement stmt = con.createStatement();


        int count = stmt.executeUpdate(sql);

        System.out.println(count);

        //释放资源
        stmt.close();
        con.close();
    }
}
