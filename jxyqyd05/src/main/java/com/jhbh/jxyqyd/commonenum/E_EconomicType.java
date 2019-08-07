package com.jhbh.jxyqyd.commonenum;


/**
 * @Auth hayden
 * @date 2019/5/17
 * 功能：经济类型；
 */
public enum E_EconomicType {

    /**
     * 内资
     */
    NEIZI("100","内资"),
    /**
     * 国有全资
     */
    STATE_OWNED("110","国有全资"),
    /**
     * 集体全资
     */
    COLLECTIVELY_WHOLLY_OWNED("120","集体全资"),
    /**
     * 股份合作
     */
    SHARE_COOPERATION("130","股份合作"),
    /**
     * 联营
     */
    JOINT_VENTURE("140","联营"),
    /**
     * 国有联营 State-owned joint venture
     */
    STATE_OWNED_JOINT_VENTURE("141","国有联营"),
    /**
     * 集体联营 Collective joint venture
     */
    COLLECTIVE_JOINT_VENTURE("142","集体联营"),
    /**
     * 国有与集体联营 State-owned and collective joint venture
     */
    STATE_OWNED_AND_COLLECTIVE_JOINT_VENTURE("143","国有与集体联营"),
    /**
     * 其他联营
     */
    OTHER_JOINT_VENTURE("149","其他联营"),
    /**
     * 有限责任(公司) limited liability company
     * 根据国家有关规定登记注册，由两个以上，五十个以下的股
     * 东共同出资，每个股东以其所认缴的出资额对公司承担有限
     * 责任，公司以其全部资产对其债务承担有限责任的经济组织
     * 的经济类型。包括国有独资公司及其他有限责任公司
     */
    LIMITED_LIABILITY_COMPANY("150","有限责任(公司)"),
    /**
     * 国有独资(公司) State-owned sole proprietorship (company)
     */
    STATE_OWNED_SOLE_PROPRIETORSHIP_COMPANY("150","国有独资(公司)"),
    /**
     * 其他有限责任(公司) other limited liability companies
     * 国有独资公司以外的其他有限责任公司的经济类型
     */
    OTHER_LIMITED_LIABILITY_COMPANIES("159","其他有限责任(公司)"),
    /**
     * 股份有限(公司) Company limited
     */
    COMPANY_LIMITED("160","股份有限(公司)"),
    /**
     * 私有 private
     */
    PRIVATE("170","私有"),
    /**
     * 私有独资 Private sole proprietorship
     */
    PRIVATE_SOLE_PROPRIETORSHIP("171","私有独资"),
    /**
     * 私有合伙 Private partnership
     */
    PRIVATE_PARTNERSHIP("172","私有合伙"),
    /**
     * 私营有限责任(公司) private Limited company
     */
    PRIVATE_LIMITED_COMPANY("173","私营有限责任(公司)"),
    /**
     * 私营股份有限(公司)  Private limited shares (company)
     */
    PRIVATE_LIMITED_SHARES_COMPANY("174","私营股份有限(公司)"),
    /**
     * 个体经营 Self-employed
     */
    SELF_EMPLOYED("175","个体经营"),
    /**
     *  其他私有 Other private
     */
    OTHER_PRIVATE("179","其他私有"),
    /**
     *  其他内资 Other domestic capital
     */
    OTHER_DOMESTIC_CAPITAL("190","其他内资"),

    ///////////////////////////// 港、澳、台投资 （HMT）
    /**
     *  内地和港、澳、台(HMT)合资 Mainland and HMT joint venture
     */
    MAINLAND_AND_HMT_JOINT_VENTURE("210","内地和港、澳、台(HMT)合资"),
    /**
     *  内地和港、澳、台(HMT)合作 Mainland and HMT cooperation
     */
    MAINLAND_AND_HME_COOPERATION("220","内地和港、澳、台(HMT)合作"),
    /**
     *  港、澳、台(HMT)独资 HMT sole proprietorship
     */
    HMT_SOLE_PROPRIETORSHIP("230","港、澳、台(HMT)独资"),
    /**
     *  港、澳、台(HMT)投资股份有限(公司) HMT Investment Shares Limited (Company)
     */
    HMT_INVESTMENT_SHARES_LIMITED_COMPANY("240","港、澳、台(HMT)投资股份有限(公司)"),
    /**
     *  其他港、澳、台(HMT)投资 Other HMT investments
     */
    OTHER_HMT_INVESTMENTS("290","其他港、澳、台(HMT)投资"),

    /////////////////////////////  国外投资
    /**
     * 中外合资 China-foreign joint venture
     */
    CHINA_FOREIGN_JOINT_VENTURE("310","中外合资"),
    /**
     * 中外合作 China cooperates with foreign countries
     */
    CHINA_COOPERATES_WITH_FOREIGN_COUNTRIES("320","中外合作"),
    /**
     *  外资 Sole proprietorship
     */
    SOLE_PROPRIETORSHIP("330","外资"),
    /**
     *  国外投资股份有限(公司) Foreign investment shares limited (company)
     */
    FOREIGN_INVESTMENT_SHARES_LIMITED_COMPANY("340","国外投资股份有限(公司)"),
    /**
     *  其他国外投资 Other types of foreign investment
     */
    OTHER_TYPES_OF_FOREIGN_INVESTMENT("390","其他国外投资"),

    /**
     *  其他
     */
    OTHER("900","其他");


    private String code;
    private String name;

    E_EconomicType(String code, String name) {
        this.code = code;
        this.name = name;
    }


    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static String getNameByCode(String code) {
        for(E_EconomicType e: E_EconomicType.values()) {
            if(e.code.equals(code)) {
            	return e.name;
            }
        }
        return null;
    }
}
