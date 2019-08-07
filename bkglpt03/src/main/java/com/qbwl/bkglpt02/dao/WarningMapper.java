package com.qbwl.bkglpt02.dao;


import com.qbwl.bkglpt02.entity.Warning;
import org.springframework.stereotype.Repository;

@Repository
public interface WarningMapper {

    int deleteByPrimaryKey(Short warnid);

    int insert(Warning record);

    int insertSelective(Warning record);

    Warning getByPrimaryKey(Short warnid);

    int updateByPrimaryKeySelective(Warning record);

    int updateByPrimaryKey(Warning record);
}