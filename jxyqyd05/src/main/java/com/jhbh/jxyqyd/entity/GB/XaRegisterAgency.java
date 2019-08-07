package com.jhbh.jxyqyd.entity.GB;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author:Hayden
 * @Date:2019/2/20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XaRegisterAgency extends GBEntity{

    private String typeName;
    private Integer xaAgencyId;           //表单标识码(序号)
    private String  agencyCode;            //区划全名
    private String  agencyName;            //区划简称
    private String  districtCode;          //代码
    private Integer districtRank;          //罗马字母拼音
    private String  districtAgenct;        //字母码

}
