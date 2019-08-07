package com.qbwl.aspect_demo.dataStageUtils;


import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:Hayden
 * @Date:2019/6/28
 */
@Data
public class SqlToJsonUtil implements Serializable {

    /**
     * 声明并初始化封存操作记录的队列queue
     */
    public static Queue<DataStageEntity<Object>> queue = new LinkedList<>();

    /**
     * 将操作记录封装进队列中
     * @param dataStageEntity 数据操作记录
     */
    public static void  addOperation(DataStageEntity<Object> dataStageEntity) {
        queue.add(dataStageEntity);
//        SqlToJsonUtil.setQueue(dataStageEntity);
    }
//    private static void setQueue(DataStageEntity<Object> queue) {
//        SqlToJsonUtil.queue = queue;
//    }
//
//    public static Queue<DataStageEntity<Object>> getQueue() {
//        return queue;
//    }
}
