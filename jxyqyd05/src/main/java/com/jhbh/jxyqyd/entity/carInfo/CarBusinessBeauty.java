package com.jhbh.jxyqyd.entity.carInfo;


/**
 * @author:Hayden
 * @Date:2019/7/1
 */
public class CarBusinessBeauty {

    //汽车美容
    private Integer bussBeautifyId;         // 表单标识码(序号)
    private String  companyCode;            // 企业代码(唯一标识)
    private String  receiveId;              // 登记序号
    private String  progectId;              // 项目序号
    private String  proBeautify;            // 美容项目
    private String  notes;                  // 备注
    private String  status;                  // 状态
    private String  createTime;             // 创建时间
    private String  modifiedTime;           // 更改时间


    public CarBusinessBeauty() {
    }


    public CarBusinessBeauty(String companyCode, String receiveId, String progectId, String proBeautify, String notes, String status, String createTime) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.progectId = progectId;
        this.proBeautify = proBeautify;
        this.notes = notes;
        this.status = status;
        this.createTime = createTime;
    }
}
