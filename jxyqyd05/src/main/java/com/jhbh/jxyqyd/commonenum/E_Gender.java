package com.jhbh.jxyqyd.commonenum;

/**
 * @Auth cuihuan
 * @date 2019/1/17 0017    11:08
 * 功能：性别表示；
 */
public enum E_Gender {

    /**
     * 0 未知，
     */
    UNKNOWN("0","未知"),
    /**
     * 1 男，
     */
    MALE("1","男"),
    /**
     * 2 女，
     */
    FEMALE("2","女"),
    /**
     * 9 未说明；
     */
    NOTSTAT("9","未说明");

    private String code;
    private String name;

    E_Gender(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String getNameByCode(String code) {
        for(E_Gender s : E_Gender.values()) {
            if(s.code.equals(code)) {
            	return s.name;
            }
        }
        return null;
    }
}
