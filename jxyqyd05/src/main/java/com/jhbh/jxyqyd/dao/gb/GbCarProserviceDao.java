package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbCarType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/27
 */
@Repository
public interface GbCarProserviceDao {

    /**
     * 获取车辆维修项目
     * @return
     */
    @Select("SELECT type_code typeCode,type_name typeName FROM `jxy_data_db`.`gb_car_proservice`")
    List<GbCarType> getCarProservice();


    /**
     * 根据修理类型代码获取车辆维修项目名称
     * @return
     */
    @Select("SELECT type_name typeName FROM `jxy_data_db`.`gb_car_proservice` where type_code=#{typeCode}")
    GbCarType getCarProserviceNameByCode(String typeCode);
}
