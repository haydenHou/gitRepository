package com.qbwl.bkglpt02.dao;

import com.qbwl.bkglpt02.entity.BDZTRY;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BDZTRYMapper {

    int deleteByPrimaryKey(String rRybh);

    int insert(BDZTRY record);

    int insertSelective(BDZTRY record);

    BDZTRY getByPrimaryKey(String rRybh);

    int updateByPrimaryKeySelective(BDZTRY record);

    int updateByPrimaryKey(BDZTRY record);

    @Select("SELECT R_XM xm,R_SFZH sfzh,R_RYBH rybh FROM T_BD_ZTRY")
    List<BDZTRY> listAll();

    /**
     * 根据xm和sfzh查询相关信息
     * @param record xm ，sfzh
     */
    List<BDZTRY> listShowEnteringBdzt(BDZTRY record);
}