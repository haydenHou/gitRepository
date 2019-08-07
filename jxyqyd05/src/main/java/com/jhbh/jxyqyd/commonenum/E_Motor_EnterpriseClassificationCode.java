package com.jhbh.jxyqyd.commonenum;

/**
 * @Auth cuihuan
 * @date 2019/1/17 0017    12:14
 * 功能：机修业 企业分类代码；
 */
public enum E_Motor_EnterpriseClassificationCode {
    /**
     * 报废机动车回收拆解 Recycling，
     */
    RECYCLING("01"),
    /**
     * 汽车修理 Motor vehicle repair，
     */
    AUTO_REPAIR("02"),
    /**
     * 摩托车修理，
     */
    MOTOR_REPAIR("03"),
    /**
     * 特种车辆修理 Special vehicle repair，
     */
    SPECIAL_VEHICLE_REPAIR("04"),
    /**
     * 机动车配件 Motor vehicle accessories，
     */
    MOTOR_VELICLE_ACCESSORIES("05"),
    /**
     * 汽车美容，
     */
    CAR_BEAUTY("06"),
    /**
     * 停车场，
     */
    PARKING("07"),
    /**
     * 其他；
     */
    OTHER("99");

    private String _value;
    private E_Motor_EnterpriseClassificationCode(String value) {
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
    public static E_Motor_EnterpriseClassificationCode element(String code) { 
        for(E_Motor_EnterpriseClassificationCode s : E_Motor_EnterpriseClassificationCode.values()) {
            if(s._value.equals(code)) {
            	return s;
            }
        }
        return null;
    }
}
