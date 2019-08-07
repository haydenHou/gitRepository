package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbCarTypeDao;
import com.jhbh.jxyqyd.entity.GB.GbCarType;
import com.jhbh.jxyqyd.service.GBService.IGbCarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
@Service
public class GbCarTypeImpl implements IGbCarTypeService {

    @Autowired
    GbCarTypeDao gbCarTypeMapper;
    @Override
    public List<GbCarType> getCarType( ) {
        return gbCarTypeMapper.getCarType();
    }
}
