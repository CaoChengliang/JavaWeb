package com.learnJavaWeb.mapper;


import com.learnJavaWeb.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /*
    * ��ѯ����
    *
    * */
    public List<Brand> selectAll();


    /*
    * ��ID��ѯ
    * */

    public Brand selectById(int id);

    /**
     *
     * ������ѯ
     *  1. ��������ѯ ��Ҫ�ڷ�������ǰ��@Param("SQL����ռλ��");
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
     * ���
     * @param brand
     */
    public void add(Brand brand);

    /**
     * ��������
     * @param brand
     * @return
     */
    public int update(Brand brand);

    /**
     * ����Idɾ��
     */
    public void deleteById(int id);

    /**
     * ����Id����ɾ��
     * @param ids
     */
    public void deleteByIds(@Param("ids") int[] ids);
}
