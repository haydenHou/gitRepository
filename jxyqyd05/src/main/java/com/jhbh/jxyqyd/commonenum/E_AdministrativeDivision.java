package com.jhbh.jxyqyd.commonenum;


/**
 * @Auth cuihuan
 * @date 2019/1/17 0017    11:58
 * 功能：行政区划代码，
 */
public enum E_AdministrativeDivision {

    /**
     * 新城区，
     */
    XIN_CHENG_QU("610102"),
    /**
     * 碑林区，
     */
    BEI_LINQU("610103"),
    /**
     * 莲湖区，
     */
    LIAN_HU_QU("610104"),
    /**
     * 灞桥区，
     */
    BA_QIAO_QU("610111"),
    /**
     * 未央区，
     */
    WEI_YANG_QU("610112"),
    /**
     * 雁塔区，
     */
    YAN_TA_QU("610113"),
    /**
     * 阎良区，
     */
    YAN_LIANG_QU("610114"),
    /**
     * 临潼区，
     */
    LIN_TONG_QU("610115"),
    /**
     * 长安县，
     */
    CHANG_AN_XIAN("610121"),
    /**
     * 蓝田县，
     */
    LAN_TIAN_XIAN("610122"),
    /**
     * 周至，
     */
    ZHOU_ZHI_XIAN("610124"),
    /**
     * 户县，
     */
    HU_XIAN("610125"),
    /**
     * 高陵县，
     */
    GAO_LING_XIAN("610126");

    private String _value;
    private E_AdministrativeDivision(String value) {
        _value = value;
    }

    /**
     * 获取枚举属性的值；
     * @return
     */
    public String value() {
        return _value;
    }
    
    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static E_AdministrativeDivision element(String code) { 
        for(E_AdministrativeDivision s : E_AdministrativeDivision.values()) {
            if(s._value.equals(code)) {
            	return s;
            }
        }
        return null;
    }
}