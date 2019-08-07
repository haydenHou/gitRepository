package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbEcotypeTable;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/28
 */
@Repository
public interface GbEcotypeTableDao {
    /**
     * 根据经济类型名称获取经济类型代码
     */
    @Select(" SELECT code,`type_name` typeName FROM gb_ecotype_table")
    List<GbEcotypeTable> getEcotype();
}
