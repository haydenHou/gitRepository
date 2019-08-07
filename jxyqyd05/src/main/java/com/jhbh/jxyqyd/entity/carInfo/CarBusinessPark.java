package com.jhbh.jxyqyd.entity.carInfo;

import lombok.Data;

/**
 * @author:Hayden
 * @Date:2019/7/1
 */
@Data
public class CarBusinessPark {

    //车辆停放
    private Integer bussParkId;                 //表单标识码(序号)
    private String  companyCode;            // 企业代码(唯一标识)
    private String  receiveId;              // 登记序号
    private String  parkId;                      //停车位号
    private String  notes;
    private String  status;
    private String  createTime;                   // 创建时间
    private String  modifiedTime;                 //更改时间


    public CarBusinessPark() {
    }


    public CarBusinessPark(String companyCode, String receiveId, String parkId, String notes, String status, String createTime) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.parkId = parkId;
        this.notes = notes;
        this.status = status;
        this.createTime = createTime;
    }
}
