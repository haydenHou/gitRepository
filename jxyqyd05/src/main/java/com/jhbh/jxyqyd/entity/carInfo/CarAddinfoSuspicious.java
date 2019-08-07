package com.jhbh.jxyqyd.entity.carInfo;

import lombok.Data;

/**
 * @author:Hayden
 * @Date:2019/7/1
 */
@Data
public class CarAddinfoSuspicious {

    //可疑车辆附加登记表
    private Integer addinfoSuspId;       //表单标识码(序号)
    private String  companyCode;            // 企业代码(唯一标识)
    private String  receiveId;              // 登记序号
    private String suspType;             //可疑情况类别
    private String suspDescribe;         //疑点详细描述
    private String reporter;
    private String reporterTime;
    private String createTime;                   // 创建时间
    private String modifiedTime;                 //更改时间


    public CarAddinfoSuspicious() {
    }

    public CarAddinfoSuspicious(String companyCode, String receiveId, String suspType, String suspDescribe, String reporter, String reporterTime, String createTime) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.suspType = suspType;
        this.suspDescribe = suspDescribe;
        this.reporter = reporter;
        this.reporterTime = reporterTime;
        this.createTime = createTime;
    }
}
