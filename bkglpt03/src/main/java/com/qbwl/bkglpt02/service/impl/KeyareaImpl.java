package com.qbwl.bkglpt02.service.impl;

import com.qbwl.bkglpt02.dao.KeyareaMapper;
import com.qbwl.bkglpt02.entity.Keyarea;
import com.qbwl.bkglpt02.exception.DeleteFailException;
import com.qbwl.bkglpt02.exception.InsertFailException;
import com.qbwl.bkglpt02.exception.NoResultException;
import com.qbwl.bkglpt02.exception.UpdateFailException;
import com.qbwl.bkglpt02.service.IKeyareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/17
 */
@Service
public class KeyareaImpl implements IKeyareaService {

    @Autowired
    KeyareaMapper keyareaMapper;

    @Override
    public void deleteByPrimaryKey(BigDecimal kaid) {
        if (keyareaMapper.deleteByPrimaryKey(kaid) !=1){
            throw new DeleteFailException("信息删除失败");
        }
    }

    @Override
    public void insert(Keyarea record) {
        if(keyareaMapper.insert(record) != 1){
            throw new InsertFailException("信息插入失败");
        }
    }

    @Override
    public void insertSelective(Keyarea record) {
        if(keyareaMapper.insertSelective(record) != 1){
            throw new InsertFailException("信息插入失败");
        }
    }

    @Override
    public Keyarea getByPrimaryKey(BigDecimal kaid) {
        Keyarea byPrimaryKey = keyareaMapper.getByPrimaryKey(kaid);
        if(byPrimaryKey == null){
            throw new NoResultException("未匹配到有效数据");
        }
        return byPrimaryKey;
    }

    @Override
    public List<Keyarea> listByKatypeAndKasecurityorg(Keyarea record) {
        List<Keyarea> keyareas = keyareaMapper.listByKatypeAndKasecurityorg(record);
        if(keyareas.size() == 0){
            throw new NoResultException("未匹配到有效数据");
        }
        return keyareas;
    }

    @Override
    public void updateByPrimaryKeySelective(Keyarea record) {
        if(keyareaMapper.updateByPrimaryKeySelective(record) != 1){
            throw new UpdateFailException("信息更改失败");
        }
    }

    @Override
    public void updateByPrimaryKey(Keyarea record) {
        if(keyareaMapper.updateByPrimaryKey(record) != 1){
            throw new UpdateFailException("信息更改失败");
        }
    }
}
