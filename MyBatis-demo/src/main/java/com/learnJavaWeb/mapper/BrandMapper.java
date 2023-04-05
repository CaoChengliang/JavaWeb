package com.learnJavaWeb.mapper;


import com.learnJavaWeb.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /*
    * 查询所有
    *
    * */
    public List<Brand> selectAll();


    /*
    * 按ID查询
    * */

    public Brand selectById(int id);

    /**
     *
     * 条件查询
     *  1. 带参数查询 需要在方法参数前加@Param("SQL参数占位符");
     *
     * @param status
     * @param companName
     * @param brandName
     * @return
     */

    //public List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companName, @Param("brandName") String brandName);

    //public List<Brand> selectByCondition(Brand brand);

    public List<Brand> selectByCondition(Map map);

    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand);

    /**
     * 更新数据
     * @param brand
     * @return
     */
    public int update(Brand brand);

    /**
     * 根据Id删除
     */
    public void deleteById(int id);

    /**
     * 根据Id批量删除
     * @param ids
     */
    public void deleteByIds(@Param("ids") int[] ids);
}
