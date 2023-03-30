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
 * Ʒ�����ݵ���ɾ�Ĳ�
 */

public class BrandTest {

    /*
     * ��ѯ����
     *
     * */
    @Test
    public void TestSelectAll() throws Exception {
//��ͨ����
//        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
//        String user = "root";
//        String password = "1234";
//        Connection conn = DriverManager.getConnection(url, user, password);
//���ݳ�����
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
//��ͨ����
//        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
//        String user = "root";
//        String password = "1234";
//        Connection conn = DriverManager.getConnection(url, user, password);
//���ݳ�����
        System.out.println(System.getProperty("user.dir"));
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "insert tb_brand(brand_name, company_name, ordered, description, status) values (?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        List<Brand> list = new ArrayList<>();



        Scanner sc = new Scanner(System.in);

        System.out.println("��������Ҫ�����Ʒ����");
        String bn = sc.nextLine();

        pstmt.setString(1,bn);

        System.out.println("��������Ҫ�����Ʒ�ƹ�˾��");
        String cn = sc.nextLine();

        pstmt.setString(2,cn);


        System.out.println("��������Ҫ�����������״̬");
        String o = sc.nextLine();


        pstmt.setInt(3,Integer.valueOf(o));

        System.out.println("��������Ҫ����Ĺ�˾����");
        String de = sc.nextLine();

        pstmt.setString(4,de);

        System.out.println("��������Ҫ����Ĺ�˾״̬");
        int st = sc.nextInt();

        pstmt.setInt(5,st);

        int rs = pstmt.executeUpdate();

        if(rs > 0){

            System.out.println("�ɹ�");
        }else{

            System.out.printf("ʧ��");
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
//��ͨ����
//        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
//        String user = "root";
//        String password = "1234";
//        Connection conn = DriverManager.getConnection(url, user, password);
//���ݳ�����
        String brandName = "��ƮƮ";
        String companyName = "��ƮƮ";
        int ordered = 1000;
        String description = "�Ƶ�����Ȧ";
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


        //4. ���ò���
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);

        //5. ִ��SQL
        int count = pstmt.executeUpdate(); // Ӱ�������
        //6. ������
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
//��ͨ����
//        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
//        String user = "root";
//        String password = "1234";
//        Connection conn = DriverManager.getConnection(url, user, password);
//���ݳ�����
        String brandName = "��ƮƮ";
        String companyName = "��ƮƮ";
        int ordered = 1000;
        String description = "�Ƶ�����Ȧ";
        int status = 1;
        int id = 6;


        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = " delete from tb_brand where id= ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);


        //4. ���ò���
        pstmt.setInt(1, id);


        //5. ִ��SQL
        int count = pstmt.executeUpdate(); // Ӱ�������
        //6. ������
        System.out.println(count > 0);


        //rs1.close();
        pstmt.close();
        conn.close();

    }

}

/*
* �޸ģ�
* ��Ҫ����
* */

