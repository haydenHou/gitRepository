package com.jhbh.jxyqyd.entity.carInfo;


/**
 * @author:Hayden
 * @Date:2019/7/1
 */
public class CarBusinessService {

    // 车辆修理
    private Integer bussServiceId;         // 表单标识码(序号)
    private String companyCode;            // 企业代码(唯一标识)
    private String receiveId;              // 登记序号
    private String progectId;              // 项目序号
    private String serCause;               // 修理原因
    private String serProject;             // 修理项目
    private String createTime;             // 创建时间
    private String modifiedTime;           // 更改时间


    public CarBusinessService() {
    }

    public CarBusinessService(String companyCode, String receiveId, String progectId, String serCause, String serProject, String createTime, String modifiedTime) {
        this.companyCode = companyCode;
        this.receiveId = receiveId;
        this.progectId = progectId;
        this.serCause = serCause;
        this.serProject = serProject;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }




}
