package com.jhbh.jxyqyd.commonenum;

/**
 * @Auth cuihuan
 * @date 2019/1/17 0017    11:21
 */


/**
 * 功能：学历程度；
 */
public enum E_EducationLevel {
    /**
     *
     */
    YJSJY("10","研究生教育"),
    BSYJSBY("11","博士研究生毕业"),
    BSYJSXY("12","博士研究生结业"),
    BSYJSYY("13","博士研究生肄业"),
    SSYJSBY("14","硕士研究生毕业"),
    SSYJSJY("15","硕士研究生结业"),
    SSYJSYY("16","硕士研究生肄业"),
    YJSBBY("17","研究生班毕业"),
    YJSBJY("18","研究生班结业"),
    YJSBYY("19","研究生班肄业"),
    DXBKJY("20","大学本科教育"),
    DXBKBY("21","大学本科毕业"),
    DXBKJIEY("22","大学本科结业"),
    DXBKYY ("23","大学本科肄业"),
    DXBTBBY("28","大学普通班毕业"),
    DXZKJY("30","大学专科教育"),
    DXZKBY("31","大学专科毕业"),
    DXZKJIEY("32","大学专科结业"),
    DXZKYY("33","大学专科肄业"),
    ZDZYJY("40","中等职业教育"),
    ZDZKBY("41","中等专科毕业"),
    ZDZKJY("42","中等专科结业"),
    ZDZKSY("43","中等专科肄业"),
    ZYGZBY("44","职业高中毕业"),
    ZYGZJY("45","职业高中结业"),
    ZYGZYY("46","职业高中肄业"),
    JGXXBY("47","技工学校毕业"),
    JGXXJY("48","技工学校结业"),
    JGXXYY("49","技工学校肄业"),
    PTGZ("60","普通高级中学教育"),
    PTGZBY("61","普通高中毕业"),
    PTGZJY("62","普通高中结业"),
    PTGZYY("63","普通高中肄业"),
    CJZXJY("70","初级中学教育"),
    CZBY("71","初中毕业"),
    CZYY("73","初中肄业"),
    XXJY("80","小学教育"),
    XXBY("81","小学毕业"),
    XXYY("83","小学肄业"),
    OTHER("90","其他");

    private String code;
    private String name;


    E_EducationLevel(String code, String name) {
        this.name = name;
        this.code = code;
    }

    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String getNameByCode(String code) {
        for(E_EducationLevel s : E_EducationLevel.values()) {
            if(s.code.equals(code)) {
            	return s.name;
            }
        }
        return null;
    }


    /**
     * 返回枚举元素
     * @param name 枚举值
     * @return 枚举元素
     */
    public static String getCodeByName(String name) {
        for(E_EducationLevel s : E_EducationLevel.values()) {
            if(s.name.equals(name)) {
                return s.code;
            }
        }
        return null;
    }
}
