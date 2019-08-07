package com.jhbh.jxyqyd.commonenum;

/**
 * @author:Hayden
 * @Date:2019/5/16
 */
public enum E_SuspType {
    /**
     *
     */
        ZJWZ("1","证明、证件有变造、伪造痕迹"),
        JSZ("2","送修车辆与机动车行驶证或回收车辆与报废证明不符"),
        FDJH("3","车辆发动机号码、车架号码有改动痕迹或车辆有其他明显改动、破坏痕迹"),
        GGFDJH("4","送修人要求更改发动机号码、车架号码"),
        GACK("5","公安机关查控的机动车辆"),
        JTZS("6","交通肇事逃逸嫌疑车辆"),
        QT("9","其他可疑情况");

    private String typeCode;
    private String typeName;

    E_SuspType(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }


    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String getNameByCode(String code) {
        for(E_SuspType e: E_SuspType.values()) {
            if(e.typeCode.equals(code)) {
                return e.typeName;
            }
        }
        return null;
    }

}
