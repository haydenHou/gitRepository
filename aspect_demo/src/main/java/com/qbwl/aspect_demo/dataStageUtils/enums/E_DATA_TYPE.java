package com.qbwl.aspect_demo.dataStageUtils.enums;

import org.springframework.lang.Nullable;

/**
 * @author:Hayden
 * @Date:2019/8/1
 */
public enum E_DATA_TYPE {

    A("User","User");

    private String typeName;
    private String tableName;

    E_DATA_TYPE(String typeName, String tableName) {
        this.typeName = typeName;
        this.tableName = tableName;
    }

    @Nullable
    public static String getTableName(String typeName){
        for (E_DATA_TYPE e:E_DATA_TYPE.values()) {
            if((e.typeName).equals(typeName)){
                return e.tableName;
            }
        }
        return null;
    }

}
