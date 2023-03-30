package com.learnJavaWeb.JDBCDemo.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.learnJavaWeb.JDBCDemo.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * 品牌数据的增删改查
 */

public class BrandTest {

    /*
     * 查询所有
     *
     * */
    @Test
    public void TestSelectAll() throws Exception {
//普通链接
//        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
//        String user = "root";
//        String password = "1234";
//        Connection conn = DriverManager.getConnection(url, user, password);
//数据池链接
        System.out.println(System.getProperty("user.dir"));
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_brand";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs1 = pstmt.executeQuery();

        List<Brand> list = new ArrayList<>();

        while (rs1.next()) {


            Integer id = rs1.getInt(1);
            String brandName = rs1.getString(2);
            String companyName = rs1.getString(3);
            int ordered = rs1.getInt(4);
            String description = rs1.getString(5);
            Integer status = rs1.getInt(6);

            Brand b = new Brand(id,brandName,companyName,ordered,description,status);

            list.add(b);


        }
        System.out.println(list);

        rs1.close();
        pstmt.close();
        conn.close();

    }

    @Test
    public void TestInsert() throws Exception {
//普通链接
//        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
//        String user = "root";
//        String password = "1234";
//        Connection conn = DriverManager.getConnection(url, user, password);
//数据池链接
        System.out.println(System.getProperty("user.dir"));
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "insert tb_brand(brand_name, company_name, ordered, description, status) values (?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        List<Brand> list = new ArrayList<>();



        Scanner sc = new Scanner(System.in);

        System.out.println("请输入您要输入的品牌名");
        String bn = sc.nextLine();

        pstmt.setString(1,bn);

        System.out.println("请输入您要输入的品牌公司名");
        String cn = sc.nextLine();

        pstmt.setString(2,cn);


        System.out.println("请输入您要输入的排序在状态");
        String o = sc.nextLine();


        pstmt.setInt(3,Integer.valueOf(o));

        System.out.println("请输入您要输入的公司描述");
        String de = sc.nextLine();

        pstmt.setString(4,de);

        System.out.println("请输入您要输入的公司状态");
        int st = sc.nextInt();

        pstmt.setInt(5,st);

        int rs = pstmt.executeUpdate();

        if(rs > 0){

            System.out.println("成功");
        }else{

            System.out.printf("失败");
        }

        String sql1 = "select * from tb_brand";

        PreparedStatement pstmt1 = conn.prepareStatement(sql1);

        ResultSet rs1 = pstmt1.executeQuery();



        while (rs1.next()) {


            Integer id = rs1.getInt(1);
            String brandName = rs1.getString(2);
            String companyName = rs1.getString(3);
            int ordered = rs1.getInt(4);
            String description = rs1.getString(5);
            Integer status = rs1.getInt(6);

            Brand b = new Brand(id,brandName,companyName,ordered,description,status);

            list.add(b);


        }
        System.out.println(list);

        System.out.println(list);

        //rs1.close();
        pstmt.close();
        conn.close();

    }

    @Test
    public void TestUpdate() throws Exception {
//普通链接
//        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
//        String user = "root";
//        String password = "1234";
//        Connection conn = DriverManager.getConnection(url, user, password);
//数据池链接
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "绕地球三圈";
        int status = 1;
        int id = 6;


        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = " update tb_brand\n" +
                "         set brand_name  = ?,\n" +
                "         company_name= ?,\n" +
                "         ordered     = ?,\n" +
                "         description = ?,\n" +
                "         status      = ?\n" +
                "     where id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);


        //4. 设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);

        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);


        //rs1.close();
        pstmt.close();
        conn.close();

    }

    /*
    * delete from tb_brand where id=?
    * */

    @Test
    public void TestDeleteById() throws Exception {
//普通链接
//        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
//        String user = "root";
//        String password = "1234";
//        Connection conn = DriverManager.getConnection(url, user, password);
//数据池链接
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "绕地球三圈";
        int status = 1;
        int id = 6;


        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = " delete from tb_brand where id= ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);


        //4. 设置参数
        pstmt.setInt(1, id);


        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);


        //rs1.close();
        pstmt.close();
        conn.close();

    }

}

/*
* 修改，
* 需要参数
* */

