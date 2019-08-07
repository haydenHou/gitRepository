package com.jhbh.jxyqyd.commonenum;

/**
 * @Auth cuihuan
 * @date 2019/1/18 0018    15:21
 * 功能：身份证明名称代码；
 */
public enum E_IDCardType {
    /**
     * 居民身份证 Resident Identity Card
     */
    RESIDENT_IDENTITY_CARD("A","居民身份证"),
    /**
     * 组织机构代码证书 License of organization code
     */
    LICENSE_OF_ORGANIZATION_CODE("B","组织机构代码证书"),
    /**
     * 军官证 Military officer card
     */
    MILITARY_OFFICER_CARD("C","军官证"),
    /**
     * 士兵证 Soldier card
     */
    SOLDIER_CARD("D","士兵证"),
    /**
     * 军官离退休证 Officer retired certificate
     */
    OFFICER_RETIRED_CERTIFICATE("E","军官离退休证"),
    /**
     * 境外人员身份证明 Proof of identity of foreign personnel
     */
    PROOF_OF_IDENTITY_OF_FOREIGN_PERSIONNEL("F","境外人员身份证明"),
    /**
     * 外交人员身份证件 Diplomatic identity document
     */
    DIPLOMATIC_IDENTITY_DOCUMENT("G","外交人员身份证件"),
    /**
     * 居民户口簿 Residents booklet
     */
    RESIDENTS_BOOKLET("H","居民户口簿"),
    /**
     * 单位注销证明 Unit cancellation certificate
     */
    UNIT_CANCELLATION_CERTIFICATE("J","单位注销证明"),
    /**
     * 居住暂住证明 Residence temporary residence certificate
     */
    RESIDENCE_TEMPORARY_RESIDENCE_CERTIFICATE("K","居住暂住证明"),
    /**
     * 驻华机构证明 Proof of agency in China
     */
    PROOF_OF_AGENCY_IN_CHINA("L","驻华机构证明"),
    /**
     * 其他证件 Other documents
     */
    OTHER("Z","其他证件");

    private String code;
    private String name;

    E_IDCardType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String getNameByCode(String code) {
        for(E_IDCardType s : E_IDCardType.values()) {
            if(s.code.equals(code)) {
            	return s.name;
            }
        }
        return null;
    }
}
