package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbIdTypeDao;
import com.jhbh.jxyqyd.entity.GB.GbIdType;
import com.jhbh.jxyqyd.service.GBService.IGbIdTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/11
 */
@Service
public class GbIdTypeImpl implements IGbIdTypeService {

    @Autowired
    GbIdTypeDao idTypeDao;

    @Override
    public List<GbIdType> listIdType() {
        return idTypeDao.listIdType();
    }
}
