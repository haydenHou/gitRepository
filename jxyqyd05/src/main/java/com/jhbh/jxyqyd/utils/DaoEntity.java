package com.jhbh.jxyqyd.utils;

import com.jhbh.jxyqyd.commonenum.Dao_Type;
import com.jhbh.jxyqyd.commonenum.Table_Name;
import com.jhbh.jxyqyd.commonenum.Table_Type;
import lombok.Data;

/**
 * @author:Hayden
 * @Date:2019/6/26
 */
@Data
public class DaoEntity<T> {

    /**
     * 参数类型   insert  update  delete
     */
    private Dao_Type daoType;

    /**
     * 表名
     */
    private Table_Name table;

    /**
     * 表对应的实体类类型
     */
    private Table_Type tableType;

    /**
     * 参数
     */
    private T data;

    public DaoEntity() {
    }

    public DaoEntity(Dao_Type daoType, Table_Name table, Table_Type tableType, T data) {
        this.daoType = daoType;
        this.table = table;
        this.tableType = tableType;
        this.data = data;
    }
}
