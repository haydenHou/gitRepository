package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbCarColorDao;
import com.jhbh.jxyqyd.entity.GB.GbCarColor;
import com.jhbh.jxyqyd.service.GBService.IGbCarColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/11
 */
@Service
public class GbCarColorImpl implements IGbCarColorService {
    @Autowired
    GbCarColorDao colorDao;

    @Override
    public List<GbCarColor> getColor() {
        return colorDao.getColor();
    }
}
