package com.qbwl.bkglpt02.service;

import com.qbwl.bkglpt02.entity.BDZTRY;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/17
 */
public interface IBDZTService {


    /**
     * 根据人员编号删除对应字段
     * @param rRybh 人员编号
     * 成功返回1，失败返回0
     */
    void deleteByPrimaryKey(String rRybh);

    /**
     * 添加
     * @param record
     * @return
     */
    void insert(BDZTRY record);

    /**
     * 选择性添加bdztry 姓名，别名，性别，生日，身份证号，联系方式，户籍地址，居住地址，身高，案件编号，案件类别，出逃日期，督捕级别，奖金，立案单位，主办人，简要案情
     * @param record
     * @return
     */
    void insertSelective(BDZTRY record);

    /**
     * 根据rybh获取ztry详情
     * @param rRybh 人员编号
     * @return
     */
    BDZTRY getByPrimaryKey(String rRybh);

    /**
     *选择性更改ztry信息
     * @param record 姓名，别名，性别，生日，身份证号，联系方式，户籍地址，居住地址，身高，案件编号，案件类别，出逃日期，督捕级别，奖金，立案单位，主办人，简要案情
     * @return 成功返回1，失败返回0
     */
    void updateByPrimaryKeySelective(BDZTRY record);

    /**
     * 更改姓名，别名，性别，生日，身份证号，联系方式，户籍地址，居住地址，身高，案件编号，案件类别，出逃日期，督捕级别，奖金，立案单位，主办人，简要案情
     * @param record
     * @return
     */
    void updateByPrimaryKey(BDZTRY record);

    /**
     * 根据人员姓名和身份证号模糊查询
     * @param bdztry xm,sfzh
     * @return rybh,xm, bmch,xb,csrq,sfzh,lxfs,hjdxz,xzdxz,sg,ajbh,ajlb,tprq,dbjb,tjjb,jj,ladwqh,zbr,jyaq
     * */
    List<BDZTRY> listShowEnteringBdzt(BDZTRY bdztry);

    /**
     * 获取全部本地在逃信息
     * @return rybh,xm, bmch,xb,csrq,sfzh,lxfs,hjdxz,xzdxz,sg,ajbh,ajlb,tprq,dbjb,tjjb,jj,ladwqh,zbr,jyaq
     */
    List<BDZTRY> listAll();

    /**
     * 根据人员姓名和身份证号统计符合的数量
     * @param bdztry xm,sfzh
     */
    Integer countEnteringBdzt(BDZTRY bdztry);
}
