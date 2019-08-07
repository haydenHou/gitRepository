package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbComtypeTable;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/17
 */
@Repository
public interface GbComtypeMapper {

    @Select("SELECT gb_comtype_id gbComtypeId,type_code typeCode,type_name typeName FROM gb_comtype_table")
    List<GbComtypeTable> listComtyoe();

    @Select("SELECT type_name typeName FROM gb_comtype_table WHERE type_code = #{typeCode}")
    GbComtypeTable  getNameByCode(String typeCode);

}
