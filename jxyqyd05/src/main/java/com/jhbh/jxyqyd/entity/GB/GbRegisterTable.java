package com.jhbh.jxyqyd.entity.GB;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author:Hayden
 * @Date:2019/1/31
 * 1.行政区划类比表  (国标GBT 2206)
 * gb_register_table
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GbRegisterTable extends GBEntity{
    private String gbRegisterId;     //表单标识码(序号)
    private String districtName;      //区划全名
    private String district;           //区划简称
    private String districtCode;      //代码
    private String spellName;         //罗马字母拼音
    private String alphaCode;         //字母码

}
