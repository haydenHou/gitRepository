package com.qbwl.aspect_demo.dataStageUtils;

import com.qbwl.aspect_demo.dataStageUtils.enums.E_OperationType;
import lombok.Data;

import java.util.Map;

/**
 * @author:Hayden
 * @Date:2019/6/26
 */
@Data
public class DataStageEntity<T> {

    /**
     * 参数类型   insert  update  delete
     */
    private E_OperationType daoType;

    /**
     * 表名
     */
    private Map methodType;

    /**
     * 表对应的实体类类型
     */
    private String tableType;

    /**
     * 参数
     */
    private T args;

    public DataStageEntity() {
    }

    public DataStageEntity(E_OperationType daoType, Map methodType, String tableType, T args) {
        this.daoType = daoType;
        this.methodType = methodType;
        this.tableType = tableType;
        this.args = args;
    }
}
