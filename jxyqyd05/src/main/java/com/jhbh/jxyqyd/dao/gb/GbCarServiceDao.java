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
public interface GbCarServiceDao {

    /**
     * 获取维修原因
     * @return
     */
    @Select("SELECT `type_code` typeCode, `type_name` typeName from gb_car_service")
    List<GbCarType> getCarService();



}
