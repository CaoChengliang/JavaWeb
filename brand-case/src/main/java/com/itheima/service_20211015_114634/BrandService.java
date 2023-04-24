package com.itheima.service_20211015_114634;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {


    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据Id查找
     * @param id
     * @return
     */
    Brand selectById(int id);

    /**
     * 更新
     * @param brand
     */
    void update(Brand brand);

    /**
     *
     * 删除
     * @param id
     */
    void deleteById( int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds( int[] ids);

    /**
     * 分页查询
     * @param currentPage  //当前页
     * @param pageSize    当前页显示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand);

}
