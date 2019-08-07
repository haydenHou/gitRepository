package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbSuspiciousType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/6/17
 */
@Repository
public interface GbSuseTypeDao {


    @Select("SELECT type_code typeCode,type_name typeName FROM gb_suspicious_type")
    List<GbSuspiciousType> getSuseType();
}
