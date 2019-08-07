package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbCarDamage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/15
 */
@Repository
public interface GbCarDamageDao {

    /**
     * 根据类型名称获取类型代码
     * @param typeName 类型名称
     * @return typeCode 类型代码
     */
    @Select("SELECT type_code typeCode,type_name typeName FROM gb_car_damage WHERE type_name like CONCAT('%',#{typeName},'%')")
    List<GbCarDamage> getCodeByName(String  typeName);

    /**
     * 根据类型代码获取类型名称
     * @param  typeCode 类型代码
     * @return typeName 类型名称
     */
    @Select("SELECT type_name typeName FROM gb_car_damage WHERE type_code = #{typeCode}")
    GbCarDamage getNameByCode(String  typeCode);

}
