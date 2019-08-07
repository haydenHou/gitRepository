package com.jhbh.jxyqyd.service.GBService;

import com.jhbh.jxyqyd.entity.GB.GbCarType;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/27
 */
public interface IGbCarProService {


    /**
     * 获取车辆维修项目
     * @return
     */
    List<GbCarType> getCarProservice();


    /**
     * 根据修理类型代码获取车辆维修项目名称
     * @return
     */
    GbCarType getCarProserviceNameByCode(String typeCode);
}
