package com.jhbh.jxyqyd.entity.carInfo;

import lombok.Data;

/**
 * @author:Hayden
 * @Date:2019/7/1
 */
@Data
public class CarInfoBasic {

    //车辆基本信息
    private Integer carBasicId;                // 表单标识码(序号)
    private String companyCode;                // 企业代码(唯一标识)
    private String receiveId;                  // 登记序号
    private String owner;                      // 车主
    private String carType;                    // 车辆类型
    private String brand;                      // 车辆品牌名称
    private String color;                      // 车身颜色 // （三合一）
    private String plateNumber;                // 车牌号
    private String engineNumber;               // 发动机号
    private String frameNumber;                // 车架号
    private String picture;                    // 车辆图像
    private String status;                     // 目前状态
    private String createTime;                   // 创建时间
    private String modifiedTime;                 //更改时间


    public CarInfoBasic() {
    }

    public CarInfoBasic(String companyCode, String receiveId, String owner, String carType, String brand, String color, String plateNumber,
                         String engineNumber, String frameNumber, String picture, String status, String createTime) {
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
        this.status = status;
        this.createTime = createTime;
    }
}
