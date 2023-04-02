package com.learnJavaWeb.JDBCDemo.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
* ��³�����ӳ�
* */
public class Druid {

    public static void main(String[] args) throws Exception {
        //1.����jar��
        
        //д����
        Properties porp = new Properties();
        porp.load(new FileInputStream("JDBC/src/druid.properties"));

        //��������
        DataSource dataSource = DruidDataSourceFactory.createDataSource(porp);

        Connection connection = dataSource.getConnection();



        //sqlע��
        String username= "zhangsan";
        String pwd = "123";

        //sql���
        String sql = "select * from tb_user where username = ? and password = ?";

        //дpreparestatment

        PreparedStatement pstmt = connection.prepareStatement(sql);

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
        connection.close();
        System.out.println(System.getProperty("user.dir"));
        connection.close();
    }

}
