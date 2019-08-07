package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbCarDamageDao;
import com.jhbh.jxyqyd.entity.GB.GbCarDamage;
import com.jhbh.jxyqyd.service.GBService.IGbCarDamageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/15
 */
@Service
public class GbCarDamageImpl implements IGbCarDamageService {

    @Autowired
    GbCarDamageDao carDamageDao;

    @Override
    public List<GbCarDamage> getCodeByName(String typeName) {
        return carDamageDao.getCodeByName(typeName);
    }

    @Override
    public String getNameByCode(String typeCode) {
        String name = null;
        if (!"null".equals(typeCode) || StringUtils.isEmpty(typeCode)) {
            try{
                GbCarDamage   names = carDamageDao.getNameByCode(typeCode);
                if(names == null){
                    name = "";
                }else{
                    name = names.getTypeName();
                }
            }catch (NullPointerException e){
                name = "";
            }
            return name;
        }else{
            return "";
        }
    }
}
