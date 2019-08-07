package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbCarType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/28
 */
@Repository
public interface GbCarTypeDao {
    /**
     * 通过汽车类型名称获取该类型代码
     * @return gb_cartype_id,type_code,type_name,explain
     */
    @Select("SELECT `type_code` typeCode, `type_name` typeName from gb_car_type")
    List<GbCarType> getCarType();

}
