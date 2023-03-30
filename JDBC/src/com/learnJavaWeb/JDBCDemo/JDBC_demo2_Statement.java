package com.learnJavaWeb.JDBCDemo;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.sql.*;

/*
* JDBC API Statement
* */
public class JDBC_demo2_Statement {

    @Test
    public void TestDML() throws Exception {
        //1.注册驱动可以不用写了
        //Class.forName("com.mysql.jdbc.Driver");


        //创建链接

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password= "1234";
        Connection con = DriverManager.getConnection(url, user, password);

        //定义sql语句
        String sql = "update account set money = 2000 where id = 2";

        //获取执行对象
        Statement stmt = con.createStatement();


        int count = stmt.executeUpdate(sql);

        //输出结果System.out.println(count);
        if(count > 0){//DML受影响的行数,ddl删除表格不能用这个判断因为回返回0
            System.out.println("修改成功！");
        }else {

            System.out.println("修改失败！");

        }

        //释放资源
        stmt.close();
        con.close();
    }
}
