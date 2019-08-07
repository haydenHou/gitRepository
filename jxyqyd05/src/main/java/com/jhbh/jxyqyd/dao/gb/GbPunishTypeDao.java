package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbPunishType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/28
 */
@Repository
public interface GbPunishTypeDao {

    /**
     * 根据处罚类型名称获取经济类型代码
     * @return
     */
    @Select("SELECT `type_code` typeCode, `type_name` typeName FROM gb_punish_type")
    List<GbPunishType> getPunishCode();
}
