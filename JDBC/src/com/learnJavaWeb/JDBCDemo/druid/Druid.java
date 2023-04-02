package com.learnJavaWeb.JDBCDemo.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
* 德鲁伊连接池
* */
public class Druid {

    public static void main(String[] args) throws Exception {
        //1.导入jar包
        
        //写配置
        Properties porp = new Properties();
        porp.load(new FileInputStream("JDBC/src/druid.properties"));

        //建立链接
        DataSource dataSource = DruidDataSourceFactory.createDataSource(porp);

        Connection connection = dataSource.getConnection();



        //sql注入
        String username= "zhangsan";
        String pwd = "123";

        //sql语句
        String sql = "select * from tb_user where username = ? and password = ?";

        //写preparestatment

        PreparedStatement pstmt = connection.prepareStatement(sql);

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
        connection.close();
        System.out.println(System.getProperty("user.dir"));
        connection.close();
    }

}
