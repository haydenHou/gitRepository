package com.jhbh.jxyqyd.entity.carInfo;

import com.jhbh.jxyqyd.entity.CarInfo;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/1
 */
public class CarBusinessParts {

    //车辆配件
    private Integer bussPartsId;            // 表单标识码(序号)
    private String  companyCode;            // 企业代码(唯一标识)
    private String  receiveId;              // 登记序号
    private String  progectId;              // 项目序号
    private String  partsName;              // 配件名称
    private String  specification;          // 规格型号
    private String  number;                 // 数量
    private String  notes;                  // 备注
    private String  createTime;             // 创建时间
    private String  modifiedTime;           // 更改时间
    private List<CarInfo> partsArray;       // 组件集合


    public CarBusinessParts() {
    }

    public CarBusinessParts(String companyCode, String receiveId, String progectId, String partsName, String specification, String number, String notes, String createTime) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.progectId = progectId;
        this.partsName = partsName;
        this.specification = specification;
        this.number = number;
        this.notes = notes;
        this.createTime = createTime;
    }

}
