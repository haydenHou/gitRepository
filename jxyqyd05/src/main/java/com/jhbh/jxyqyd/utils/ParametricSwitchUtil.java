package com.jhbh.jxyqyd.utils;

import com.jhbh.jxyqyd.commonenum.*;
import com.jhbh.jxyqyd.entity.CarInfo;
import com.jhbh.jxyqyd.entity.ComServiceWorkers;
import com.jhbh.jxyqyd.service.GBService.GBImpl.GbCarDamageImpl;
import com.jhbh.jxyqyd.service.GBService.IGbCarDamageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/6/11
 * 类型转换工具类
 * 用于员工信息，车辆信息的转换
 */
public class ParametricSwitchUtil {

    @Autowired
    IGbCarDamageService damage;
    /**
     * 人员参数类型转换
     * @param c comServiceWorkers
     */
    public static void workerInfoSwitch(ComServiceWorkers c){
        if(c.getDegree()!= null){
            c.setDegreeN(E_EducationLevel.getNameByCode(c.getDegree()));
        }
        if(c.getSex()!=null){
            c.setSexN(E_Gender.getNameByCode(c.getSex()));
        }
    }


    /**
     * 车辆参数类型转换
     *   carType     ：车辆类型;
     *   color       ：车身颜色;
     *   suspType    ：可疑情况类别;
     *   partsName   ：配件名称;
     *   serCase     ：修理原因;
     *   serProject  ：修理项目;
     */
    public static void carInfoSwitch(@NotNull List<CarInfo> carInfo){
        for (CarInfo car : carInfo) {
            if(car != null) {
                carInfoSwitch(car);
            }
        }

    }

    /**
     * 车身颜色
     * @param car
     * @param color
     */
    private static void switchColor(CarInfo car, String color) {
        if (StringUtils.isNotEmpty(color)) {
            StringBuilder buffer = new StringBuilder();
            char[] chars = color.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                buffer.append(E_Color.getNameByCode(chars[i] + ""));
                if (chars.length - i > 1) {
                    buffer.append(",");
                }
            }
            car.setColorN(buffer.toString());
        }
    }


    /**
     * 车辆参数类型转换
     *   carType     ：车辆类型;
     *   color       ：车身颜色;
     *   suspType    ：可疑情况类别;
     *   partsName   ：配件名称;
     *   serCase     ：修理原因;
     *   serProject  ：修理项目;
     */
    public static void carInfoSwitch(@NotNull CarInfo car){
        GbCarDamageImpl gbCarDamage = new GbCarDamageImpl();

            String carType = car.getCarType();
            String color = car.getColor();
            String brand = car.getBrand();
            String damage1 = car.getDamage1();
            String damage2 = car.getDamage2();
            String damage3 = car.getDamage3();
            String suspType = car.getSuspType();
            String senderType = car.getSenderType();
            String takerType = car.getTakerType();
//            String partsName = car.getPartsName();
            String serCase   = car.getSerCause();
            String serProject = car.getSerProject();

            if(StringUtils.isNotEmpty(senderType)){
                car.setSenderTypeN(E_IDCardType.getNameByCode(senderType));
            }

            if(StringUtils.isNotEmpty(takerType)){
                car.setTakerTypeN(E_IDCardType.getNameByCode(takerType));
            }

            if(StringUtils.isNotEmpty(carType)){
                car.setCarTypeN(E_CarType.getNameByCode(carType));
            }

            switchColor(car, color);

//            if(StringUtils.isNotEmpty(damage1)){
//                car.setDamage1(gbCarDamage.getNameByCode(damage1));
//            }
            if(StringUtils.isNotEmpty(suspType)){
                car.setSuspTypeN(E_SuspType.getNameByCode(suspType));
            }
//            if(StringUtils.isNotEmpty(partsName)){
//                car.setPartsName(E_CarType.getNameByCode(partsName));
//            }
            if(StringUtils.isNotEmpty(serCase)){
                car.setSerCauseN(E_SerCase.getNameByCode(serCase));
            }

            switchSerProject(car, serProject);
    }

    /**
     * 修理项目匹配
     * @param car 车辆信息
     * @param serProject 修理项目
     */
    private static void switchSerProject(@NotNull CarInfo car, String serProject) {
        if (StringUtils.isNotEmpty(serProject)) {
            StringBuilder str = new StringBuilder();
            String[] split = serProject.split(",");
            for (int i = 0; i < split.length; i++) {
                str.append(E_SerProject.getNameByCode(split[i]));
                if (split.length - i > 1) {
                    str.append(",");
                }
            }
            car.setSerProjectN(str + "");
        }
    }


}
