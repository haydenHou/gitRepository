package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbCarColor;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/8
 */
@Repository
public interface GbCarColorDao {
   @Select("select code typeCode,color typeName from gb_car_color")
   List<GbCarColor> getColor();
}
