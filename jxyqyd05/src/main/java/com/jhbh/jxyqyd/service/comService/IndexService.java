package com.jhbh.jxyqyd.service.comService;

import com.jhbh.jxyqyd.entity.CarInfo;

import java.util.List;
import java.util.Map;

/**
 * @author:Hayden
 * @Date:2019/7/3
 */
public interface IndexService {


    Map<String ,Object> showIndexData(CarInfo carInfo);

    Map<String,Object>showCountNum(CarInfo carInfo);

    List<String> setTimes(int timeZone);
}
