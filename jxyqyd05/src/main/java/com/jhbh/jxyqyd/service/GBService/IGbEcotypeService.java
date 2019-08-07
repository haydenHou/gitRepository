package com.jhbh.jxyqyd.service.GBService;


import com.jhbh.jxyqyd.entity.GB.GbEcotypeTable;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
public interface IGbEcotypeService {

    /**
     * 根据经济类型名称获取经济类型代码
     * @return
     */
    List<GbEcotypeTable> getEcotype();

}
