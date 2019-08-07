package com.jhbh.jxyqyd.utils.dataTransmission;

import com.alibaba.fastjson.JSON;
import com.jhbh.jxyqyd.commonenum.Table_Type;
import com.jhbh.jxyqyd.service.comService.ICarInfoService;
import com.jhbh.jxyqyd.utils.SqlToJsonUtil;
import com.jhbh.jxyqyd.utils.DaoEntity;
import com.jhbh.jxyqyd.utils.ftpUtils.FtpEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Queue;

/**
 * @author:Hayden
 * @Date:2019/6/26
 * 数据上传
 */
@Service
public class ResolverSqlDataUtil {

    @Autowired
    ICarInfoService carInfoService;


    @Scheduled(cron = "0/2 * * * * *")
    private void sqlDataToTxt(){
        Object poll;
        OutputStream ops;
        StringBuilder stringBuilder = new StringBuilder();
        Queue<DaoEntity<Object>> queue = SqlToJsonUtil.getQueue();
        if(queue!=null){
            if(queue.size()>0){
                poll = queue.poll();
                Table_Type tableType = ((DaoEntity) poll).getTableType();
                String  sqlPath = getSqlPathByTableType(tableType);
                stringBuilder.append(JSON.toJSONString(poll));
                try {
                    ops = new BufferedOutputStream(new FileOutputStream(FtpEntity.sqlPath+sqlPath,true));
                    ops.write((stringBuilder+"\r").getBytes());
                    ops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据tableType确定sql存放路径
     * @param tableType 实体类类型
     */
    @NotNull
    private String getSqlPathByTableType(Table_Type tableType) {
        String sqlPath = null;
        switch (tableType){
            case CarInfo:
                sqlPath = "CarInfo.txt";
                break;
            case ComInfoTable:
                sqlPath = "ComInfoTable.txt";
                break;
            case ComServiceWorkers:
                sqlPath = "ComServiceWorkers.txt";
                break;
            case ComInfoChange:
                sqlPath = "ComInfoChange.txt";
                break;
            default:
        }
        return sqlPath;
    }
}
