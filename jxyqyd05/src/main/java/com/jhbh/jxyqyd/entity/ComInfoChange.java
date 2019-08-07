package com.jhbh.jxyqyd.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NonNull;

/**
 * @Author:Hayden
 * @Date:2019/3/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComInfoChange extends BaseEntity{

   private Integer comInfoId;
   private Integer infoChangeId;                                  //表单序列
   private String companyCode;                                    //公司代码
   private String changeDate;                                      //更改日期
   private String changeType;                                    //更改类型
   private String contentBefore;                                 //更改之前内容
   private String contentBeforeId;                              //变更前法人身份证号身份证号
   private String contentAfter;                                  //更改之后内容
    @NonNull
   private String contentAfterId;                               //变更后法人身份证号
   private String createTime;                                     //创建时间
   private String status;                                       //审核状态  0 待审核 1未通过 2通过
   private String modifiedTime;                                  //更改时间

    private String startTime;
    private String endTime;


    public ComInfoChange(){
    }





    public ComInfoChange(String companyCode, String changeDate, String changeType,String contentAfter, String contentBefore, String createTime,String modifiedTime) {
        this.companyCode = companyCode;
        this.changeDate = changeDate;
        this.changeType = changeType;
        this.contentAfter = contentAfter;
        this.contentBefore = contentBefore;
        this.createTime = createTime;
        this.modifiedTime=modifiedTime;
    }
}
