package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbIdType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/11
 */
@Repository
public interface GbIdTypeDao {

    @Select("select code,type_name typeName from gb_id_type")
    List<GbIdType> listIdType();

}
