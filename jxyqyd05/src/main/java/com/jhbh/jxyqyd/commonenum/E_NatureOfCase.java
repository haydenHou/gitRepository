package com.jhbh.jxyqyd.commonenum;

/**
 * @Auth cuihuan
 * @date 2019/1/17 0017    12:12
 * 功能：案事件性质；
 */
public enum E_NatureOfCase {

    /**
     * 刑事案件 Criminal case，CRIMINAL_CASE；
     * 治安案件 Security case，SECURITY_CASE；
     */
    CRIMINAL_CASE("0","刑事案件"),
    /**
     * 刑事案件 Criminal case，CRIMINAL_CASE；
     * 治安案件 Security case，SECURITY_CASE；
     */
    SECURITY_CASE("1","治安案件");

    private String code;
    private String name;

    E_NatureOfCase(String code, String name) {
        this.code = code;
        this.name = name;
    }


    
    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String element(String code) {
        for(E_NatureOfCase s : E_NatureOfCase.values()) {
            if(s.code.equals(code)) {
            	return s.name;
            }
        }
        return null;
    }
}
