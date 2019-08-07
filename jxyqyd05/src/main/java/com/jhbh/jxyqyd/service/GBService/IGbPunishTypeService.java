package com.jhbh.jxyqyd.service.GBService;


import com.jhbh.jxyqyd.entity.GB.GbPunishType;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
public interface IGbPunishTypeService {
    /**
     * 根据处罚类型名称获取经济类型代码
     * @return
     */
    List<GbPunishType> getPunishCode();

}
