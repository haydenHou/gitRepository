package com.jhbh.jxyqyd.service.GBService;


import com.jhbh.jxyqyd.entity.GB.GbCarType;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
public interface IGbCarTypeService {

    /**
     * 通过汽车类型名称获取该类型代码
     * @return gb_cartype_id,type_code,type_name,explain
     */
    List<GbCarType> getCarType();
}
