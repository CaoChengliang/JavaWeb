package com.itheima.service_20211015_114634;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {


    /**
     * ��ѯ����
     * @return
     */
    List<Brand> selectAll();

    /**
     * �������
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * ����Id����
     * @param id
     * @return
     */
    Brand selectById(int id);

    /**
     * ����
     * @param brand
     */
    void update(Brand brand);

    /**
     *
     * ɾ��
     * @param id
     */
    void deleteById( int id);

    /**
     * ����ɾ��
     * @param ids
     */
    void deleteByIds( int[] ids);

    /**
     * ��ҳ��ѯ
     * @param currentPage  //��ǰҳ
     * @param pageSize    ��ǰҳ��ʾ����
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand);

}
