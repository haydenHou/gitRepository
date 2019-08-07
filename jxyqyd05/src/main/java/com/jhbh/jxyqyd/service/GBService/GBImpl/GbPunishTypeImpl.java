package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbPunishTypeDao;
import com.jhbh.jxyqyd.entity.GB.GbPunishType;
import com.jhbh.jxyqyd.service.GBService.IGbPunishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
@Service
public class GbPunishTypeImpl implements IGbPunishTypeService {

    @Autowired
    GbPunishTypeDao punishTypeMapper;
    @Override
    public List<GbPunishType> getPunishCode() {
        return punishTypeMapper.getPunishCode();
    }
}
