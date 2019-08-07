package com.qbwl.bkglpt02.utils;

import com.qbwl.bkglpt02.service.IBDZTService;
import com.qbwl.bkglpt02.service.IQGZTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:Hayden
 * @Date:2019/7/24
 */

public class InformationMatching {

    @Autowired
    IQGZTService qgztryService;

    @Autowired
    IBDZTService bdztryService;


    Logger logger = LoggerFactory.getLogger(InformationMatching.class);

    private String xm ;
    private String sfzh;
    private String lxfs;


    /**
     * 将本地在逃库的人员与全国在逃库的人员进行信息比对
     * 姓名信息
     * 联系方式
     * 身份证号
     */
    public  void matchingZTRY(){
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间"+ startTime);
        InformationMatching i = new InformationMatching();
        i.matchingZTRY();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }







}
