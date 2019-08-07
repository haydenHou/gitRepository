package com.jhbh.jxyqyd.commonenum;

/**
 * @Auth cuihuan
 * @date 2019/1/18 0018    15:52
 * 功能：机动车修理项目代码；
 *      1XX - 总成修理
 *      2XX - 专项修理
 */
public enum E_SerProject {
    /**
     *
     */
    ZC("100","总成修理"),
    /**
     *  engine
     */
    ENGINE("101","发动机"),
    /**
     *  Direction machine
     */
    DIRECTION_MACHINE("102","方向机"),
    /**
     *  transmission
     */
    TRANSMISSION("103","变速器"),
    /**
     *  Front and rear bridge
     */
    FRONT_AND_REAR_BRIDGE("104","前后桥"),
    /**
     *  Frame
     */
    FRAME("105","车架"),
    /**
     *  Spray paint
     */
    SPRAY_PAINT("201","喷/烤漆"),
    /**
     *  Electrical repair
     */
    ELECTRICAL_REPAIR("202","电气修理"),
    /**
     *  Air conditioner (heater) repair
     */
    AIR_CONDITIONER_HEATER_REPAIR("203","空调器(暖风机)修理"),
    /**
     *  Battery repair
     */
    BATTERY_REPAIR("204","蓄电池修理"),
    /**
     *  Battery charging
     */
    BATTERY_CHARGING("205","蓄电池充电"),
    /**
     *  Radiator (water tank) repair
     */
    RADIATOR_WATERTANK_REPAIR("206","散热器(水箱)修理"),
    /**
     *  Tire repair inflation
     */
    TIRE_REPAIR_INFLATION("207","轮胎修补充气"),
    /**
     *  Door and window glass installation
     */
    DOOR_AND_WINDOW_GLASS_INSTALLATION("208","门窗玻璃安装"),
    /**
     *  Cloth cover and interior decoration
     */
    CLOTH_COVER_AND_INTERIOR_DOCORATION("209","蓬布座套及内装饰"),
    /**-
     *  High pressure fuel injection pump repair
     */
    HIGH_PRESSURE_FUEL_INJECTION_PUMP_REPAIR("210","高压喷油泵修理"),
    /**
     *  High pressure oil filling (oil change)
     */
    HIGH_PRESSURE_OIL_FILLING_OR_OIL_CHANGE("211","高压注油(换油)"),
    /**
     *  Car body modification
     */
    CAR_BODY_MODIFICATION("212","车身改装"),
    /**
     *  Wheeled construction machinery maintenance and repair
     */
    WHEELED_CONSTRUCTION_MACHINERY_MAINTENANCE_AND_REPAIR("213","轮式工程机械维护与修理"),
    /**
     *  Crankshaft grinding
     */
    CRANKSHAFT_GRINDING("214","曲轴修磨"),
    /**
     *  Car body repair
     */
    CAR_BODY_REPAIR("215","车身修理"),
    /**
     *
     */
    ;

    private String code;
    private String name;

    E_SerProject(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String getNameByCode(String code) {
        for(E_SerProject s : E_SerProject.values()) {
            if(s.code.equals(code)) {
            	return s.name;
            }
        }
        return null;
    }
}
