package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbEcotypeTableDao;
import com.jhbh.jxyqyd.entity.GB.GbEcotypeTable;
import com.jhbh.jxyqyd.service.GBService.IGbEcotypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
@Service
public class GbEcotypeImpl implements IGbEcotypeService {

    @Autowired
    GbEcotypeTableDao ecotypeTableMapper;


    @Override
    public List<GbEcotypeTable> getEcotype( ) {
        return ecotypeTableMapper.getEcotype();
    }
}
