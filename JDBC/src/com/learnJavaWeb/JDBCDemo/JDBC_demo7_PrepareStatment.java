package com.learnJavaWeb.JDBCDemo;

import org.junit.Test;

import java.sql.*;

/*
* JDBC API Statement
* */
public class JDBC_demo7_PrepareStatment {


/*
*
* ��ʾPreparestament ��ֹsqlע��
* */
    @Test
    public void TestPreparestatment() throws Exception {
        //1.ע���������Բ���д��
        //Class.forName("com.mysql.jdbc.Driver");


        //��������

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String user = "root";
        String password= "1234";
        Connection conn = DriverManager.getConnection(url, user, password);
        //sqlע��
        String username= "zhangsan";
        String pwd = "123";

        //sql���
        String sql = "select * from tb_user where username = ? and password = ?";

        //дpreparestatment

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,username);
        pstmt.setString(2,pwd);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            System.out.println("1��½�ɹ�");
        }else{
            System.out.println("2��½ʧ��");
        }

        rs.close();
        pstmt.close();
        conn.close();

    }
}
