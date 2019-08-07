package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbRegisterTable;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/1/31
 */
@Repository
public interface GbRegisterTableDao {

    /**
     * 查询到所有的区域的名称
     */
    @Select("SELECT " +
                "district_name as districtName,district_code as districtCode " +
            "FROM " +
                "gb_register_table")
    List<GbRegisterTable> listDistrict();

    /**
     * 根据治安管理机构代码获取治安管理机构名称
     * @param districtCode 治安管理机构代码
     * @return 治安管理机构名称
     */
    @Select("SELECT district_name as districtName FROM gb_register_table  WHERE district_code=#{districtCode}")
    GbRegisterTable getNameByCode(String districtCode);





}
