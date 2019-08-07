package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.GbDegreeTable;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/28
 */
@Repository
public interface GbDegreeDao {

    /**
     * 根据学历名称获取学历代码
     * @param
     * @return gb_degree_id，type_code，degree，explain
     */
    @Select("select type_code typeCode,degree from gb_degree_table")
    List<GbDegreeTable> getDegree();
}
