package com.learnJavaWeb.test;

import com.learnJavaWeb.mapper.BrandMapper;
import com.learnJavaWeb.mapper.UserMapper;
import com.learnJavaWeb.pojo.Brand;
import com.learnJavaWeb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAllUser() throws IOException {
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper Usermapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = Usermapper.selectAll();

        System.out.println(users);

        sqlSession.close();

    }
    @Test
    public void testSelectUserById() throws IOException {
        int id =1;

        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper Usermapper = sqlSession.getMapper(UserMapper.class);

        User user = Usermapper.selectById(id);

        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public  void testSelectAll() throws IOException {
        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandmapper.selectAll();

        System.out.println(brands);

        sqlSession.close();


    }


    @Test
    public  void testSelectById() throws IOException {
        //����id����
        int id = 1;
        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandmapper.selectById(id);
        System.out.println(brand);

        sqlSession.close();


    }

    @Test
    public  void testSelectByCondition() throws IOException {
        //���ز���
        int status = 1;
        String companyName = "��Ϊ";
        String brandName = "��Ϊ";

        //ģ����ѯ�����ݴ���
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

       /* //����������
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);*/


        /*
        * ��̬��ѯ
        * ������ö�̬��ѯ����һ��ֵûѡ�򣬲鲻�����
        *  ��BrandMapper.xml�н��
        *
        * */
        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
       // map.put("brandName",brandName);

        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        //List<Brand> brands = brandmapper.selectByCondition(status, companyName, brandName);

       // List<Brand> brands = brandmapper.selectByCondition(brand);
        List<Brand> brands = brandmapper.selectByCondition(map);
        System.out.println(brands);

        sqlSession.close();


    }

    @Test
    public  void testAdd() throws IOException {
        //���ز���
        int status = 1;
        int order =100;
        String companyName = "����";
        String brandName = "�����ֻ�";
        String description = "�����е�ս����";


        //ģ����ѯ�����ݴ���
       /* companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";*/

        //����������
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(100);


        /*
         * ��̬��ѯ
         * ������ö�̬��ѯ����һ��ֵûѡ�򣬲鲻�����
         *  ��BrandMapper.xml�н��
         *
         * */
       /* Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        // map.put("brandName",brandName);*/

        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        brandmapper.add(brand);

        sqlSession.commit();

        sqlSession.close();


    }

    /**
     * ��������
     * @throws IOException
     */
    @Test
    public  void testAdd2() throws IOException {
        //���ز���
        int status = 1;
        int order =100;
        String companyName = "����";
        String brandName = "�����ֻ�";
        String description = "�����е�ս����";


        //ģ����ѯ�����ݴ���
       /* companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";*/

        //����������
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(100);


        /*
         * ��̬��ѯ
         * ������ö�̬��ѯ����һ��ֵûѡ�򣬲鲻�����
         *  ��BrandMapper.xml�н��
         *
         * */
       /* Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        // map.put("brandName",brandName);*/

        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        brandmapper.add(brand);

        int id = brand.getId();
        System.out.println(id);

        sqlSession.commit();

        sqlSession.close();


    }

    @Test
    public  void testupdate() throws IOException {
        //���ز���
        int status = 1;
        int order =200;
        String companyName = "����";
        String brandName = "ff�����ֻ�ad";
        String description = "aa�����е�ս����";
        int id = 5;

        //ģ����ѯ�����ݴ���
       /* companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";*/

        //����������
        Brand brand = new Brand();
       // brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        //brand.setStatus(status);
        //brand.setDescription(description);
        //brand.setOrdered(100);
        brand.setId(5);


        /*
         * ��̬��ѯ
         * ������ö�̬��ѯ����һ��ֵûѡ�򣬲鲻�����
         *  ��BrandMapper.xml�н��
         *
         * */
       /* Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        // map.put("brandName",brandName);*/

        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        int count = brandmapper.update(brand);


        System.out.println(count);

        sqlSession.commit();

        sqlSession.close();


    }

    @Test
    public  void deletById() throws IOException {
        //���ز���

        int id = 5;



        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        brandmapper.deleteById(id);



        sqlSession.commit();

        sqlSession.close();


    }


    @Test
    public  void deletByIds() throws IOException {
        //���ز���

        int[] ids = {4,6};



        //1.����mybatis�������ļ���ֻдһ�Σ���ȡSqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis�����ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.��ȡSqlSession����ִ��SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        brandmapper.deleteByIds(ids);



        sqlSession.commit();

        sqlSession.close();


    }

}
