package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbRegisterTableDao;
import com.jhbh.jxyqyd.entity.GB.GbRegisterTable;
import com.jhbh.jxyqyd.service.GBService.IGbRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
@Service
public class GbRegisterImpl implements IGbRegisterService {
@Autowired
GbRegisterTableDao registerTableMapper;

    @Override
    public List<GbRegisterTable> listDistrict() {
        return registerTableMapper.listDistrict();
    }

    @Override
    public GbRegisterTable getNameByCode(String districtCode) {
        return registerTableMapper.getNameByCode(districtCode);
    }
}
