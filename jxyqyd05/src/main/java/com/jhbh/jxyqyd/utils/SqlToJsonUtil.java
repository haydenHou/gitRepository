package com.jhbh.jxyqyd.utils;

import com.jhbh.jxyqyd.commonenum.Dao_Type;
import com.jhbh.jxyqyd.commonenum.Table_Name;
import com.jhbh.jxyqyd.commonenum.Table_Type;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:Hayden
 * @Date:2019/6/28
 */
public class SqlToJsonUtil implements Serializable {

    private static Queue<DaoEntity<Object>> queue = new LinkedList<>();

    public static void  addDaoData(Dao_Type daoType, Table_Name tableName, Table_Type tableType, Object data) {
        DaoEntity<Object> daoEntity = new DaoEntity<>(daoType, tableName,tableType, data);
        queue.add(daoEntity);
        SqlToJsonUtil.setQueue(queue);
    }

    private static void setQueue(Queue<DaoEntity<Object>> queue) {
        SqlToJsonUtil.queue = queue;
    }

    public static Queue<DaoEntity<Object>> getQueue() {
        return queue;
    }
}
