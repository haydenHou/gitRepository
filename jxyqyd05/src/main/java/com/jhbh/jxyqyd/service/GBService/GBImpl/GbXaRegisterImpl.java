package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbXaRegisterTableDao;
import com.jhbh.jxyqyd.entity.GB.XaRegisterAgency;
import com.jhbh.jxyqyd.service.GBService.IGbXaRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/11
 */
@Service
public class GbXaRegisterImpl implements IGbXaRegisterService {
    @Autowired
    GbXaRegisterTableDao xaRegisterTableDao;

    @Override
    public List<XaRegisterAgency> listXaRegister(String districtCode) {
        return xaRegisterTableDao.listXaRegister(districtCode);
    }

    @Override
    public XaRegisterAgency gerAgency(String agencyCode) {
        return xaRegisterTableDao.gerAgency(agencyCode);
    }
}
