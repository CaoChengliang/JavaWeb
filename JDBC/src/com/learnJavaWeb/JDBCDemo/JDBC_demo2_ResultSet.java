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
public class JDBC_demo2_ResultSet {

//    @Test
//    public void TestResult() throws Exception {
//        //1.注册驱动可以不用写了
//        //Class.forName("com.mysql.jdbc.Driver");
//
//
//        //创建链接
//
//        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
//        String user = "root";
//        String password= "1234";
//        Connection conn = DriverManager.getConnection(url, user, password);
//
//        //定义sql语句
//        String sql = "select * from account";
//
//        //获取statement对象
//        Statement stmt = conn.createStatement();
//
//        ResultSet rs = stmt.executeQuery(sql);
//
//        while(rs.next()){
//
//            int id = rs.getInt("id");
//            String name = rs.getString(2);
//            double money = rs.getDouble(3);
//
//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(money);
//            System.out.println("---------------------------");
//
//        }
//    }


/*
*
*
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

        //定义sql语句
        String sql = "select * from account";

        //获取statement对象
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        List<Account> list = new ArrayList<>();

        while(rs.next()){
            Account acc = new Account();
            int id = rs.getInt("id");
            String name = rs.getString(2);
            double money = rs.getDouble(3);

            acc.setId(id);
            acc.setMoney(money);
            acc.setName(name);
            list.add(acc);

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("---------------------------");

        }
        System.out.println(list);
        rs.close();
        stmt.close();
        conn.close();
    }
}
