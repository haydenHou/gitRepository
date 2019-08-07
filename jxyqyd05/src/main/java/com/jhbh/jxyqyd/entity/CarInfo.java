package com.jhbh.jxyqyd.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/18
 * 为了多表查询而创建的合并表
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public  class CarInfo extends BaseEntity implements Serializable {


    //车辆基本信息
    private Integer carBasicId;                // 表单标识码(序号)
    private String  companyCode;                // 企业代码(唯一标识)
    private String  receiveId;                  // 登记序号
    private String  owner;                      // 车主

    private String  carType;                    // 车辆类型 代码
    private String  carTypeN;                   // 车辆类型 名称

    private String  brand;                      // 车辆品牌名称
    private String  color;                      // 车身颜色 // （三合一）
    private String  colorN;
    private String  plateNumber;                // 车牌号
    private String  engineNumber;               // 发动机号
    private String  frameNumber;                // 车架号
    private String  picture;                    // 车辆图像
    private String  status;                     // 目前状态

    //汽车美容
    private Integer bussBeautifyId;             //表单标识码(序号)
    private String  progectId;                   //项目序号
    private String  proBeautify;                 //美容项目
    private String  notes;                       //备注

     //车辆停放
    private Integer bussParkId;                 //表单标识码(序号)
    private String  parkId;                      //停车位号

    //车辆配件
    private Integer bussPartsId;             //表单标识码(序号)

    private String  partsName;                //配件名称
    private String  partsNameN;                //配件名称

    private String  specification;            //规格型号
    private String  number;                   //数量
    private List<CarInfo> partsArray;         //组件集合

   // 车辆修理
    private Integer bussServiceId;            //表单标识码(序号)
    private String serCause;                 //修理原因 代码
    private String serCauseN;                 //修理原因 名称

    private String serProject;               //修理项目 代码
    private String serProjectN;              //修理项目 名称


    //车辆交接
    private Integer carCoonId;           // 表单标识码(序号)
    private String  sender;              // 送车人姓名

    private String  senderType;          // 送车人证件类别
    private String  senderTypeN;         // 送车人证件类别  名称

    private String  senderCode;          // 送车人证件号
    private String  senderPhone;         // 送车人证件号
    private String  senderIsself;
    private String  accTime;             // 收车时间
    private String  appointTime;         // 约定取车时间
    private String  accidentCar;         // 事故车辆
    private String  suspiciousCar;       // 可疑车辆
    private String  accepter;            // 受理人员姓名
    private String  taker;               // 取车人姓名

    private String  takerType;           // 取车人证件类型代码
    private String  takerTypeN;          // 取车人证件类型名称

    private String  takerCode;          // 取车人证件号码
    private String  takerPhone;         // 取车人证件号码
    private String  takerIsself;
    private String  takeTime;           // 实际取车时间
    private String  isself;             //是否本人


    //事故车辆附加信息
    private Integer addinfoAcciId;      //表单标识码(序号)
    private String  accidentCode;       //事故证明编号
    private String  accidentUnit;       //事故证明出具单位名称
    private String  damage1;            //损毁部位一
    private String  damage2;            //损毁部位二
    private String  damage3;            //损毁部位三
    private String  reporter;           //报告人
    private String  reportTime;         //报告时间

    //可疑车辆附加登记表
    private Integer addinfoSuspId;       //表单标识码(序号)

    private String  suspType;            //可疑情况类别 代码
    private String  suspTypeN;           //可疑情况类别 名称

    private String  suspDescribe;         //疑点详细描述
    private String  createTime;           // 创建时间
    private String  modifiedTime;         //更改时间


    public CarInfo() {
    }

    /**
     * 车辆基本信息录入
     * @param companyCode 企业代码
     * @param receiveId 登记序号
     * @param owner 车主
     * @param carType  车辆类型
     * @param brand 车辆品牌
     * @param color 车身颜色
     * @param plateNumber 车牌号
     * @param engineNumber 发动机号
     * @param frameNumber 车架号
     * @param picture  照片
     */
    public CarInfo(String companyCode,String receiveId, String owner, String carType, String brand, String color, String plateNumber, String engineNumber, String frameNumber,String picture) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.owner = owner;
        this.carType = carType;
        this.brand = brand;
        this.color = color;
        this.plateNumber = plateNumber;
        this.engineNumber = engineNumber;
        this.frameNumber = frameNumber;
        this.picture = picture;
    }

    /**
     * 车辆交接信息录入
     * @param companyCode  企业代码
     * @param receiveId  登记序号
     * @param sender    送车人姓名
     * @param senderType  送车人证件类型
     * @param senderCode  送车人身份证号
     * @param senderPhone 送车人电话
     * @param accTime     收车时间
     * @param appointTime 约定取车时间
     * @param accidentCar 事故车辆
     * @param suspiciousCar 可疑车辆
     * @param accepter  收车人姓名
     */
    public CarInfo(String companyCode, String receiveId, String sender, String senderType, String senderCode, String senderPhone, String accTime, String appointTime, String accidentCar, String suspiciousCar, String accepter,String createTime) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.sender = sender;
        this.senderType = senderType;
        this.senderCode = senderCode;
        this.senderPhone = senderPhone;
        this.accTime = accTime;
        this.appointTime = appointTime;
        this.accidentCar = accidentCar;
        this.suspiciousCar = suspiciousCar;
        this.accepter = accepter;
        this.createTime = createTime;
    }

    public CarInfo(String companyCode, String receiveId, String progectId,String serCause, String serProject,String notes,String status,String createTime, String modifiedTime) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.progectId = progectId;
        this.notes = notes;
        this.serCause = serCause;
        this.serProject = serProject;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "pageNum='" + getPageNum() + '\'' +
                ",pageSize='" + getPageSize() + '\'' +
                ",cname='" + super.cname + '\'' +
                ", moduleId=" + moduleId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", username='" + username + '\'' +
                ", userRank='" + userRank + '\'' +
                ", timeZone=" + timeZone +
                ", carBasicId=" + carBasicId +
                ", companyCode='" + companyCode + '\'' +
                ", receiveId='" + receiveId + '\'' +
                ", owner='" + owner + '\'' +
                ", carType='" + carType + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", engineNumber='" + engineNumber + '\'' +
                ", frameNumber='" + frameNumber + '\'' +
                ", picture='" + picture + '\'' +
                ", status='" + status + '\'' +
                ", bussBeautifyId=" + bussBeautifyId +
                ", progectId='" + progectId + '\'' +
                ", proBeautify='" + proBeautify + '\'' +
                ", notes='" + notes + '\'' +
                ", bussParkId=" + bussParkId +
                ", parkId='" + parkId + '\'' +
                ", bussPartsId=" + bussPartsId +
                ", partsName='" + partsName + '\'' +
                ", specification='" + specification + '\'' +
                ", number='" + number + '\'' +
                ", partsArray=" + partsArray +
                ", bussServiceId=" + bussServiceId +
                ", serCause='" + serCause + '\'' +
                ", serProject='" + serProject + '\'' +
                ", carCoonId=" + carCoonId +
                ", sender='" + sender + '\'' +
                ", senderType='" + senderType + '\'' +
                ", senderCode='" + senderCode + '\'' +
                ", senderPhone='" + senderPhone + '\'' +
                ", senderIsself='" + senderIsself + '\'' +
                ", accTime='" + accTime + '\'' +
                ", appointTime='" + appointTime + '\'' +
                ", accidentCar='" + accidentCar + '\'' +
                ", suspiciousCar='" + suspiciousCar + '\'' +
                ", accepter='" + accepter + '\'' +
                ", taker='" + taker + '\'' +
                ", takerType='" + takerType + '\'' +
                ", takerCode='" + takerCode + '\'' +
                ", takerPhone='" + takerPhone + '\'' +
                ", takerIsself='" + takerIsself + '\'' +
                ", takeTime='" + takeTime + '\'' +
                ", isself='" + isself + '\'' +
                ", addinfoAcciId=" + addinfoAcciId +
                ", accidentCode='" + accidentCode + '\'' +
                ", accidentUnit='" + accidentUnit + '\'' +
                ", damage1='" + damage1 + '\'' +
                ", damage2='" + damage2 + '\'' +
                ", damage3='" + damage3 + '\'' +
                ", reporter='" + reporter + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", addinfoSuspId=" + addinfoSuspId +
                ", suspType='" + suspType + '\'' +
                ", suspDescribe='" + suspDescribe + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }
}
