package com.qbwl.bkglpt02.service;


import com.qbwl.bkglpt02.entity.BDZTRY;
import com.qbwl.bkglpt02.entity.QGZTRY;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/10
 */
public interface IQGZTService {


    /**
     * 根据rybh获取ztry详情
     * @param rRybh 人员编号
     * @return
     */
    QGZTRY getByPrimaryKey(String rRybh);

    /**
     * 根据人选姓名查询在逃人员信息
     * @param qgztry xm,sfzh,lxfs  姓名，身份证号，联系方式
     * @return rybh,xm, bmch,xb,csrq,sfzh,lxfs,hjdxz,xzdxz,sg,ajbh,ajlb,tprq,dbjb,tjjb,jj,ladwqh,zbr,jyaq
     */
    List<QGZTRY> listBySFZH(QGZTRY qgztry);

    /**
     * 根据人员姓名和身份证号模糊查询
     * @param bdztry xm,sfzh,startNum,endNum
     * @return rybh,xm, bmch,xb,csrq,sfzh,lxfs,hjdxz,xzdxz,sg,ajbh,ajlb,tprq,dbjb,tjjb,jj,ladwqh,zbr,jyaq
     * */
    List<QGZTRY> listShowEnteringBdzt(BDZTRY bdztry);




}
