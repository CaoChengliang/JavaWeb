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
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper Usermapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = Usermapper.selectAll();

        System.out.println(users);

        sqlSession.close();

    }
    @Test
    public void testSelectUserById() throws IOException {
        int id =1;

        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper Usermapper = sqlSession.getMapper(UserMapper.class);

        User user = Usermapper.selectById(id);

        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public  void testSelectAll() throws IOException {
        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandmapper.selectAll();

        System.out.println(brands);

        sqlSession.close();


    }


    @Test
    public  void testSelectById() throws IOException {
        //加载id数据
        int id = 1;
        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandmapper.selectById(id);
        System.out.println(brand);

        sqlSession.close();


    }

    @Test
    public  void testSelectByCondition() throws IOException {
        //加载参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //模糊查询对数据处理
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

       /* //传入对象参数
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);*/


        /*
        * 动态查询
        * 如果不用动态查询，有一个值没选则，查不出结果
        *  再BrandMapper.xml中解决
        *
        * */
        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
       // map.put("brandName",brandName);

        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
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
        //加载参数
        int status = 1;
        int order =100;
        String companyName = "博导";
        String brandName = "波导手机";
        String description = "公鸡中的战斗机";


        //模糊查询对数据处理
       /* companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";*/

        //传入对象参数
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(100);


        /*
         * 动态查询
         * 如果不用动态查询，有一个值没选则，查不出结果
         *  再BrandMapper.xml中解决
         *
         * */
       /* Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        // map.put("brandName",brandName);*/

        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        brandmapper.add(brand);

        sqlSession.commit();

        sqlSession.close();


    }

    /**
     * 主键返回
     * @throws IOException
     */
    @Test
    public  void testAdd2() throws IOException {
        //加载参数
        int status = 1;
        int order =100;
        String companyName = "博导";
        String brandName = "波导手机";
        String description = "公鸡中的战斗机";


        //模糊查询对数据处理
       /* companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";*/

        //传入对象参数
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(100);


        /*
         * 动态查询
         * 如果不用动态查询，有一个值没选则，查不出结果
         *  再BrandMapper.xml中解决
         *
         * */
       /* Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        // map.put("brandName",brandName);*/

        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
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
        //加载参数
        int status = 1;
        int order =200;
        String companyName = "博导";
        String brandName = "ff波导手机ad";
        String description = "aa公鸡中的战斗机";
        int id = 5;

        //模糊查询对数据处理
       /* companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";*/

        //传入对象参数
        Brand brand = new Brand();
       // brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        //brand.setStatus(status);
        //brand.setDescription(description);
        //brand.setOrdered(100);
        brand.setId(5);


        /*
         * 动态查询
         * 如果不用动态查询，有一个值没选则，查不出结果
         *  再BrandMapper.xml中解决
         *
         * */
       /* Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        // map.put("brandName",brandName);*/

        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        int count = brandmapper.update(brand);


        System.out.println(count);

        sqlSession.commit();

        sqlSession.close();


    }

    @Test
    public  void deletById() throws IOException {
        //加载参数

        int id = 5;



        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        brandmapper.deleteById(id);



        sqlSession.commit();

        sqlSession.close();


    }


    @Test
    public  void deletByIds() throws IOException {
        //加载参数

        int[] ids = {4,6};



        //1.加载mybatis的配置文件，只写一次，获取SqlSessionFactory
        String resource = "mybatis-config.xml";//mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);

        brandmapper.deleteByIds(ids);



        sqlSession.commit();

        sqlSession.close();


    }

}
