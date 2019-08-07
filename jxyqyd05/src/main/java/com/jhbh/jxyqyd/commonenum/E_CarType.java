package com.jhbh.jxyqyd.commonenum;

/**
 * @Auth cuihuan
 * @date 2019/1/18 0018    9:08
 * 功能：车辆类型
 */
public enum E_CarType {
    /**
     * 客车 bus
     */
    BUS("K","客车"),
    /**
     * 货车 truck
     */
    TRUCK("H","货车"),
    /**
     * 牵引车 Tractor
     */
    SEMI_TRACTOR("Q","牵引车"),
    /**
     * 专项作业车 Special work vehicle
     */
    SPECIAL_WORK_VEHICLE("Z","专项作业车"),
    /**
     * 电车 tram
     */
    TRAM("D","电车"),
    /**
     * 摩托车 motorcycle
     */
    MOTORCYCLE("M","摩托车"),
    /**
     * 三轮汽车 Three-wheeled car
     */
    THREE_WHEELED_CAR("N","三轮汽车"),
    /**
     * 拖拉机 tractor
     */
    TRACTOR("T","拖拉机"),
    /**
     * 轮式机械 Wheeled machinery
     */
    WHEELED_MACHINERY("J","轮式机械"),
    /**
     * 全挂车 Trailer
     */
    TRAILER("G","全挂车"),
    /**
     * 半挂车 Semi-trailer
     */
    SEMI_TRAILER("B","半挂车"),
    /**
     * 其他 Other
     */
    OTHER("X","其他");

    private String code;
    private String name;

    E_CarType(String code, String name) {
        this.code = code;
        this.name = name;
    }


    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String getNameByCode(String code) {
        for(E_CarType s : E_CarType.values()) {
            if(s.code.equals(code)) {
            	return s.name;
            }
        }
        return null;
    }


    public static String getCodeByName(String name) {
        for(E_CarType s : E_CarType.values()) {
            if(s.name.equals(name)) {
                return s.code;
            }
        }
        return null;
    }
}
