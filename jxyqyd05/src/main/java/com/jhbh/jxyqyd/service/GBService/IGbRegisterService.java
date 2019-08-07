package com.jhbh.jxyqyd.service.GBService;


import com.jhbh.jxyqyd.entity.GB.GbRegisterTable;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
public interface IGbRegisterService {

    /**
     * 查询到所有的区域的名称
     */
    List<GbRegisterTable> listDistrict();

    /**
     * 根据治安管理机构代码获取治安管理机构名称
     * @param districtCode 治安管理机构代码
     * @return 治安管理机构名称
     */
    GbRegisterTable getNameByCode(String districtCode);

}
