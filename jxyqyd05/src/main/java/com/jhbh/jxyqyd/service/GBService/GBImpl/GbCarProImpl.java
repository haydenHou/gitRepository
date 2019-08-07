package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbCarProserviceDao;
import com.jhbh.jxyqyd.entity.GB.GbCarType;
import com.jhbh.jxyqyd.service.GBService.IGbCarProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/27
 */
@Service
public class GbCarProImpl implements IGbCarProService {
    @Autowired
    GbCarProserviceDao proserviceDao;



    @Override
    public List<GbCarType> getCarProservice() {
        return proserviceDao.getCarProservice();
    }

    @Override
    public GbCarType getCarProserviceNameByCode(String typeCode) {
        return proserviceDao.getCarProserviceNameByCode(typeCode);
    }
}
