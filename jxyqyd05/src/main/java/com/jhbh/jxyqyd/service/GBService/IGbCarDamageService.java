package com.jhbh.jxyqyd.service.GBService;

import com.jhbh.jxyqyd.entity.GB.GbCarDamage;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/15
 */
public interface IGbCarDamageService {


    /**
     * 根据类型名称获取类型代码
     * @param typeName 类型名称
     * @return typeCode 类型代码
     */
    List<GbCarDamage> getCodeByName(String  typeName);

    /**
     * 根据类型代码获取类型名称
     * @param  typeCode 类型代码
     * @return typeName 类型名称
     */
    String getNameByCode(String  typeCode);
}
