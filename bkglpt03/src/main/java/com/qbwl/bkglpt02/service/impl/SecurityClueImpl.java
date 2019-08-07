package com.qbwl.bkglpt02.service.impl;

import com.qbwl.bkglpt02.dao.SecurityClueMapper;
import com.qbwl.bkglpt02.entity.SecurityClue;
import com.qbwl.bkglpt02.service.ISecurityClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/16
 */
@Service
public class SecurityClueImpl implements ISecurityClueService {

    @Autowired
    SecurityClueMapper securityClueMapper;

    @Override
    public int deleteByPrimaryKey(String scid) {
        return securityClueMapper.deleteByPrimaryKey(scid);
    }

    @Override
    public int insert(SecurityClue record) {
        return securityClueMapper.insert(record);
    }

    @Override
    public int insertSelective(SecurityClue record) {
        return securityClueMapper.insertSelective(record);
    }

    @Override
    public SecurityClue selectByPrimaryKey(String scid) {
        return securityClueMapper.getByPrimaryKey(scid);
    }

    @Override
    public List<SecurityClue> listBySelective(SecurityClue record) {
        return securityClueMapper.listBySelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SecurityClue record) {
        return securityClueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SecurityClue record) {
        return securityClueMapper.updateByPrimaryKey(record);
    }
}
