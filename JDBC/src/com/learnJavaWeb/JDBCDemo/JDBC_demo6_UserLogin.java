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
* ��ʾsqlע��
* */
    @Test
    public void TestResult2() throws Exception {
        //1.ע���������Բ���д��
        //Class.forName("com.mysql.jdbc.Driver");


        //��������

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password= "1234";
        Connection conn = DriverManager.getConnection(url, user, password);
        //sqlע��
        String username= "zhagsan";
        String pwd = "' or '1' = '1";

        String sql = "select * from tb_user where username ='"+username+"' and password = '"+pwd+"'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        if(rs.next()){
            System.out.println("1��½�ɹ�");
        }else{
            System.out.println("2��½ʧ��");
        }

        rs.close();
        stmt.close();
        conn.close();

    }
}
