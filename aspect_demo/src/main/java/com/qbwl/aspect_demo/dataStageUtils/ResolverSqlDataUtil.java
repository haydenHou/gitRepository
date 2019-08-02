package com.qbwl.aspect_demo.dataStageUtils;

import com.alibaba.fastjson.JSON;
import com.qbwl.aspect_demo.dataStageUtils.enums.E_DATA_TYPE;
import com.qbwl.aspect_demo.dataStageUtils.enums.E_OperationType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.*;
import java.util.Queue;

import static com.qbwl.aspect_demo.dataStageUtils.FtpEntity.sqlPath;
import static com.qbwl.aspect_demo.dataStageUtils.enums.E_OperationType.*;

/**
 * @author:Hayden
 * @Date:2019/6/26
 * 数据上传
 */
@Service
public class ResolverSqlDataUtil {


    @Scheduled(cron = "0/30 * * * * *")
    private void sqlDataToTxt(){
        Object poll;
        OutputStream ops;
        StringBuilder stringBuilder = new StringBuilder();
        Queue<DataStageEntity<Object>> queue = SqlToJsonUtil.queue;
        if(queue != null){
            if(queue.size()>0){
                poll = queue.poll();
                E_OperationType daoType = ((DataStageEntity) poll).getDaoType();
                String sqlPath = getSqlPathByTableType(daoType);
                File file = new File(FtpEntity.sqlPath);
                if(!file.exists()){
                    boolean mkdirs = file.mkdirs();
                }
                stringBuilder.append(JSON.toJSONString(poll));
                try {
                    ops = new BufferedOutputStream(new FileOutputStream(file+"/"+sqlPath,true));

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
     * @param daoType 操作类型
     */
    @NotNull
    private String getSqlPathByTableType(E_OperationType daoType) {
        String sqlPath = null;
        switch (daoType){
            case INSERT:
                sqlPath = "insert.txt";
                break;
            case UPDATE:
                sqlPath = "update.txt";
                break;
            case DELETE:
                sqlPath = "delete.txt";
                break;
            default:
        }
        return sqlPath;
    }
}
