package com.itheima.service_20211015_114634.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service_20211015_114634.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    //获取工厂
      SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Brand> selectAll() {

        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();

        sqlSession.close();


        return  brands;


    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        sqlSession.commit();

        sqlSession.close();


    }

    @Override
    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectById(id);

        return  brand;

    }

    @Override
    public void update(Brand brand) {

        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.update(brand);

        sqlSession.commit();

        sqlSession.close();

    }

    @Override
    public void deleteById(int id) {

        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteById(id);

        sqlSession.commit();

        sqlSession.close();

    }

    @Override
    public void deleteByIds(int[] ids) {
        //
        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteByIds(ids);

        System.out.println(ids);

        sqlSession.commit();

        sqlSession.close();


    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //开始索引
        int begin = (currentPage - 1) * pageSize;
        //查询条目数
        int size = pageSize;

        List<Brand> rows = mapper.selectByPage(begin, size);
        int totalCount = mapper.selectTotalCount();

        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        sqlSession.close();

        return pageBean;


    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //开始索引
        int begin = (currentPage - 1) * pageSize;
        //查询条目数
        int size = pageSize;

        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length() > 0){

            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if(companyName != null && companyName.length() > 0){

            brand.setCompanyName("%"+companyName+"%");
        }

        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);
        int totalCount = mapper.selectTotalCountByCondition(brand);

        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        sqlSession.close();

        return pageBean;
    }
}
