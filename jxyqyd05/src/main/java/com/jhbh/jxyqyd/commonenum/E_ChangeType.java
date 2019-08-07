package com.jhbh.jxyqyd.commonenum;

/**
 * @Author:Hayden
 * @Date:2019/4/10
 */
public enum E_ChangeType {

    /**
     * 变更项(国标GA 436 5.3)
     * 1：企业更名
     * 2：企业换址
     * 3：更换法人
     * 4：治安负责人
     * 5：治安管理机构
     */

    CHANGE_NAME("1","企业更名"),
    CHANGE_ADDRESS("2","企业换址"),
    CHAGNE_LEGPERSON("3","更换法人"),
    CHANGE_SECURITY("4","治安负责人"),
    CHANGE_AGENCY("5","治安管理机构");

    private String code;
    private String name;

    E_ChangeType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(String code){
        for (E_ChangeType e:E_ChangeType.values()) {
            if(e.code.equals(code)){
                return e.name;
            }
        }
        return null;
    }

    public static String getCodeByName(String name){
        for (E_ChangeType e:E_ChangeType.values()) {
            if(e.name.equals(name)){
                return e.code;
            }
        }
        return null;
    }
}
