package com.jhbh.jxyqyd.entity.carInfo;

import lombok.Data;

/**
 * @author:Hayden
 * @Date:2019/7/1
 */
@Data
public class CarAddinfoAccident {

    //事故车辆附加信息
    private Integer addinfoAcciId;      //表单标识码(序号)
    private String companyCode;
    private String receiveId;
    private String accidentCode;       //事故证明编号
    private String accidentUnit;       //事故证明出具单位名称
    private String damage1;            //损毁部位一
    private String damage2;            //损毁部位二  -- 未使用
    private String damage3;            //损毁部位三  -- 未使用
    private String reporter;           //报告人
    private String reportTime;         //报告时间
    private String notes;
    private String status;
    private String createTime;                   // 创建时间
    private String modifiedTime;                 //更改时间


    public CarAddinfoAccident() {
    }

    public CarAddinfoAccident(String companyCode, String receiveId, String accidentCode, String accidentUnit, String damage1, String damage2, String damage3, String reporter, String reportTime, String notes, String status, String createTime) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.accidentCode = accidentCode;
        this.accidentUnit = accidentUnit;
        this.damage1 = damage1;
        this.damage2 = damage2;
        this.damage3 = damage3;
        this.reporter = reporter;
        this.reportTime = reportTime;
        this.notes = notes;
        this.status = status;
        this.createTime = createTime;
    }
}
