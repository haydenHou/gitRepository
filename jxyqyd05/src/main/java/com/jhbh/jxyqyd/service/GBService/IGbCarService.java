package com.jhbh.jxyqyd.service.GBService;

import com.jhbh.jxyqyd.entity.GB.GbCarType;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/27
 */
public interface IGbCarService {


    /**
     * 获取维修原因
     * @return
     */
    List<GbCarType> getCarService();
}
