package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbCarServiceDao;
import com.jhbh.jxyqyd.entity.GB.GbCarType;
import com.jhbh.jxyqyd.service.GBService.IGbCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/27
 */
@Service
public class GbCarImpl implements IGbCarService {
    @Autowired
    GbCarServiceDao carServiceDao;


    @Override
    public List<GbCarType> getCarService() {
        return carServiceDao.getCarService();
    }
}
