package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbComtypeMapper;
import com.jhbh.jxyqyd.entity.GB.GbComtypeTable;
import com.jhbh.jxyqyd.service.GBService.IGBComtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/17
 */
@Service
public class GbComtypeImpl implements IGBComtypeService {
    @Autowired
    GbComtypeMapper comtypeMapper;

    @Override
    public List<GbComtypeTable> listComtyoe() {
        return comtypeMapper.listComtyoe();
    }

    @Override
    public GbComtypeTable getNameByCode(String code) {
        return comtypeMapper.getNameByCode(code);
    }
}
