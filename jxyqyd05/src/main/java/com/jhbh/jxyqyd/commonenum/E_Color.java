package com.jhbh.jxyqyd.commonenum;


/**
 * @Auth cuihuan
 * @date 2019/1/18 0018    9:56
 * 功能：车辆品牌名称；
 */
public enum E_Color {
    /**
     * 白色，
     */
    WHITE("A","白"),
    /**
     * 灰，
     */
    GRAY("B","灰"),
    /**
     * 黄，
     */
    YELLOW("C","黄"),
    /**
     * 粉，
     */
    PINK("D","粉"),
    /**
     * 红，
     */
    RED("E","红"),
    /**
     * 紫，
     */
    PURPLE("F","紫"),
    /**
     * 绿,
     */
    GREEN("G","绿"),
    /**
     * 蓝，
     */
    BLUE("H","蓝"),
    /**
     * 棕，
     */
    BROWN("I","棕"),
    /**
     * 黑，
     */
    BLACK("J","黑"),
    /**
     * 其他，
     */
    OTHER("Z","其他");

    private String code;
    private String name;

    E_Color(String code, String name) {
        this.code = code;
        this.name = name;
    }


    
    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String getNameByCode(String code) {
        for(E_Color s : E_Color.values()) {
            if(s.code.equals(code)) {
            	return s.name;
            }
        }
        return null;
    }
}
