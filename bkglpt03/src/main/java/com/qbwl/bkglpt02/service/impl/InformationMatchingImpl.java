package com.qbwl.bkglpt02.service.impl;

import com.qbwl.bkglpt02.entity.BDZTRY;
import com.qbwl.bkglpt02.entity.QGZTRY;
import com.qbwl.bkglpt02.service.IBDZTService;
import com.qbwl.bkglpt02.service.IQGZTService;
import com.qbwl.bkglpt02.service.InformationMatchingService;
import com.qbwl.bkglpt02.utils.InformationMatching;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/26
 */
@Service
public class InformationMatchingImpl implements InformationMatchingService {

    @Autowired
    IQGZTService qgztryService;

    @Autowired
    IBDZTService bdztryService;

    Logger logger = LoggerFactory.getLogger(InformationMatching.class);

    @Override
    public void matchingZTRY() {
        logger.info("嫌犯检索开始执行，开始时间[{}]",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        List<BDZTRY> bdztries = bdztryService.listAll();
        int i = 0;
        for (BDZTRY bdzt:bdztries) {
            String xm = bdzt.getXm();
            String sfzh = bdzt.getSfzh();
            String lxfs = bdzt.getLxfs();
            QGZTRY qgztry = new QGZTRY();
            qgztry.setXm(xm);
            qgztry.setSfzh(sfzh);
            qgztry.setLxfs(lxfs);
//            如果本地在逃库和全国在逃库的人员信息比对成功，则更改本地在逃库嫌犯状态为报警
            if (qgztryService.listBySFZH(qgztry).size()>0){
                i++;
//                触发报警，状态更改为1,进行人工核实
                bdzt.setStatus("1");
                bdztryService.updateByPrimaryKeySelective(bdzt);
                logger.error("嫌疑人身份证号码为[{}]，请紧急布控",bdzt.getSfzh());
            }
        }
        logger.info("嫌犯检索执行结束，共匹配到[{}]条数据，结束时间[{}]",i,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * 每天 01:10 执行嫌疑人检索
     */
    @Scheduled(cron = "* 33 16 * * ?")
    private void handler(){
        matchingZTRY();
    }
}
