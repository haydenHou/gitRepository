package com.jhbh.jxyqyd.service.GBService;

import com.jhbh.jxyqyd.entity.GB.XaRegisterAgency;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/11
 */
public interface IGbXaRegisterService {


    List<XaRegisterAgency> listXaRegister(String districtCode);

    XaRegisterAgency gerAgency(String agencyCode);
}
