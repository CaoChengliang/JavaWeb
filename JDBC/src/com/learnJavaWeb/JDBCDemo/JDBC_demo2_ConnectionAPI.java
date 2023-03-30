package com.learnJavaWeb.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
* JDBC API Connection
* */
public class JDBC_demo2_ConnectionAPI {

    public static void main(String[] args) throws Exception {
        //1.注册驱动可以不用写了
        //Class.forName("com.mysql.jdbc.Driver");


        //创建链接

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password= "1234";
        Connection con = DriverManager.getConnection(url, user, password);

        //定义sql语句
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";

        //获取执行对象
        Statement stmt = con.createStatement();
        try {//再catch中处理回滚，如果出现错误的花、话
            //开启事务
            con.setAutoCommit(false);
            int count1 = stmt.executeUpdate(sql1);

            System.out.println(count1);

            int count2 = stmt.executeUpdate(sql2);

            System.out.println(count2);

            //提交事务
            con.commit();
        } catch (Exception throwables) {
            //事务回滚
            con.rollback();
            throwables.printStackTrace();
        }

        //释放资源
        stmt.close();
        con.close();
    }
}
