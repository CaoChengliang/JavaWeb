package com.learnJavaWeb.JDBCDemo.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Map;
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

        System.out.println(System.getProperty("user.dir"));
        connection.close();
    }

}
