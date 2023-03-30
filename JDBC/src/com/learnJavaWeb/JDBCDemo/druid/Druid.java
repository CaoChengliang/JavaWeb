package com.learnJavaWeb.JDBCDemo.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Map;
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

        System.out.println(System.getProperty("user.dir"));
        connection.close();
    }

}
