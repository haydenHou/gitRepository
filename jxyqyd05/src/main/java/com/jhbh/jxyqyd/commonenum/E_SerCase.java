package com.jhbh.jxyqyd.commonenum;

/**
 * @author hayden
 * @Date:2019/5/17
 */
public enum E_SerCase {

    /**
     *  General maintenance，
     */
    GENERAL_MAINTENANCE("1","一般保养"),
    /**
     * ，normal driving
     */
    NORMAL_DRIVING("2","正常行驶造成的部件老化、磨损和报废"),
    /**
     *  Traffic accident，
     */
    TRAFFIC_ACCIDENT("3","交通事故"),
    /**
     *  Other accidents，
     */
    OTHER_ACCIDENTS("4","其他事故"),
    /**
     *  Customer request replacement，
     */
    CUSTOMER_REQUEST_REPLACEMENT("5","顾客要求更换"),
    /**
     * ，
     */
    OTHER("9","其他原因");

    private String code;
    private String name;

    E_SerCase(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String getNameByCode(String code) {
        for(E_SerCase s : E_SerCase.values()) {
            if(s.code.equals(code)) {
            	return s.name;
            }
        }
        return null;
    }
}
