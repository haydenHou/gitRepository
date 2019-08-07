package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbSuseTypeDao;
import com.jhbh.jxyqyd.entity.GB.GbSuspiciousType;
import com.jhbh.jxyqyd.service.GBService.IGbSuseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/6/17
 */
@Service
public class GbSuseTypeService implements IGbSuseTypeService {

    @Autowired
    GbSuseTypeDao gbSuseTypeDao;
    @Override
    public List<GbSuspiciousType> getSuseType() {
        return gbSuseTypeDao.getSuseType();
    }
}
