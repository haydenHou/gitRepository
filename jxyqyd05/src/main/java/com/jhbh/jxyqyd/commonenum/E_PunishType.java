package com.jhbh.jxyqyd.commonenum;

/**
 * @Author:Hayden
 * @Date:2019/4/8
 * 惩罚类型
 */
public enum E_PunishType {
    /**
     * 
     */
    JG("1","警告"),
    FK("2","罚款"),
    MSFFSD("3","没收非法所得"),
    MSFFSDBCFK("4","没收非法所得并处罚款"),
    TYZD("5","停业整顿"),
    DXXKZ("6","吊销许可证"),
    ZJXSZR("7","追究刑事责任"),
    QT("9","其他处罚");

    private String code;

    private String name;

    E_PunishType(String code,String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据枚举代码获取枚举值
     * @param code 枚举代码
     * @return 枚举值
     */
    public static String getNameByCode(String code){
        for (E_PunishType p:E_PunishType.values()) {
            if(p.code.equals(code)){
                return p.name;
            }
        }
        return null;
    }
}
