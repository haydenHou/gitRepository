package com.jhbh.jxyqyd.entity.carInfo;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author:Hayden
 * @Date:2019/7/1
 */
@Data
@Entity
public class CarInfoConnect  {
    //车辆交接

    private Integer carCoonId;               // 表单标识码(序号)
    private String companyCode;
    private String receiveId;
    private String sender;                  // 送车人姓名
    private String senderType;              // 送车人证件类别
    private String senderCode;              // 送车人证件号
    private String senderPhone;              // 送车人证件号
    private String senderIsself;
    private String accTime;               // 收车时间
    private String appointTime;          // 约定取车时间
    private String accidentCar;            // 事故车辆
    private String suspiciousCar;          // 可疑车辆
    private String accepter;               // 受理人员姓名
    private String taker;                  // 取车人姓名
    private String takerType;              // 取车人证件类型
    private String takerCode;              // 取车人证件号码
    private String takerPhone;              // 取车人证件号码
    private String takerIsself;
    private String takeTime;                 // 实际取车时间
    private String createTime;                   // 创建时间
    private String modifiedTime;                 //更改时间


    public CarInfoConnect() {
    }

    public CarInfoConnect(String companyCode, String receiveId, String sender, String senderType,
                          String senderCode, String senderPhone, String senderIsself, String accTime,
                          String appointTime, String accidentCar, String suspiciousCar, String accepter, String createTime) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.sender = sender;
        this.senderType = senderType;
        this.senderCode = senderCode;
        this.senderPhone = senderPhone;
        this.senderIsself = senderIsself;
        this.accTime = accTime;
        this.appointTime = appointTime;
        this.accidentCar = accidentCar;
        this.suspiciousCar = suspiciousCar;
        this.accepter = accepter;
        this.createTime = createTime;
    }
}
