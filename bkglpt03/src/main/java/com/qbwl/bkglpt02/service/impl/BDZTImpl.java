package com.qbwl.bkglpt02.service.impl;

import com.qbwl.bkglpt02.aspect.anno.SysLog;
import com.qbwl.bkglpt02.commonenum.E_EXCEPTION;
import com.qbwl.bkglpt02.dao.BDZTRYMapper;
import com.qbwl.bkglpt02.entity.BDZTRY;
import com.qbwl.bkglpt02.exception.DeleteFailException;
import com.qbwl.bkglpt02.exception.InsertFailException;
import com.qbwl.bkglpt02.exception.NoResultException;
import com.qbwl.bkglpt02.exception.UpdateFailException;
import com.qbwl.bkglpt02.service.IBDZTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/17
 */
@Service
public class BDZTImpl implements IBDZTService {

    @Autowired
    BDZTRYMapper bdztryMapper;

    @Override
    public void deleteByPrimaryKey(String rRybh) {
        if(bdztryMapper.deleteByPrimaryKey(rRybh) != 1){
            throw new DeleteFailException("信息删除失败");
        }
    }

    @Override
    public void insert(BDZTRY record) {
        if (bdztryMapper.insert(record) != 1){
            throw new InsertFailException("信息插入失败");
        }
    }

    @Override
    public void insertSelective(BDZTRY record) {
        if(bdztryMapper.insertSelective(record) !=1 ){
            throw new InsertFailException("信息插入失败");
        }

    }

    @Override
    @SysLog("getBdzt")
    public BDZTRY getByPrimaryKey(String rRybh) {
        BDZTRY byPrimaryKey = bdztryMapper.getByPrimaryKey(rRybh);
        if(byPrimaryKey == null){
            throw new NoResultException("未匹配到有效数据");
        }
        return byPrimaryKey;
    }

    @Override
    public void updateByPrimaryKeySelective(BDZTRY record) {
        if (bdztryMapper.updateByPrimaryKeySelective(record)!=1){
            throw new UpdateFailException(record.getRybh()+"\t"+record.getXm()+"\t"+record.getStatus()+"信息更改失败");
        }
    }

    @Override
    public void updateByPrimaryKey(BDZTRY record) {
        if(bdztryMapper.updateByPrimaryKey(record)!=1){
            throw new UpdateFailException(E_EXCEPTION.UPDATE_FAILE.getMessage());
        }
    }

    @Override
    public List<BDZTRY> listShowEnteringBdzt(BDZTRY bdztry) {
        List<BDZTRY> bdztries = bdztryMapper.listShowEnteringBdzt(bdztry);
        if(bdztries.size() == 0){
            throw new NoResultException("未匹配到有效数据");
        }
        return bdztries;
    }

    @Override
    public List<BDZTRY> listAll() {
        return bdztryMapper.listAll();
    }

    @Override
    public Integer countEnteringBdzt(BDZTRY bdztry) {
        return null;
    }


}
