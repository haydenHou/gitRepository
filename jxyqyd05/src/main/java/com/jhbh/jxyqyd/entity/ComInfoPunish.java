package com.jhbh.jxyqyd.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;



/**
 * @Author:Hayden
 * @Date:2019/2/25
 * 4、企业处罚信息表
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComInfoPunish extends BaseEntity{
    private   Integer infoPunishId;               //    表单标识码(序号)
    private   String  companyCode;                //    企业代码(唯一标识)
    private   String  cname;
    private   String  punishTime;                 //    处罚日期
    private   String  punishFileCode;             //    行政处罚批准文号
    private   String  approvalAgency;             //    批准机构
    private   String  approver;                   //    批准人
    private   String  executor;                   //    执行人
    private   String  punishReason;               //    处罚原因
    private   String  punishType;                 //    处罚类别
    private   String  punishRange;                //    幅度
    private   String  penalizedPerson;            //    被处罚人
    private   String createTime;                 //    创建时间
    private   String  modifiedTime;               //    修改时间

    private   String startTime;
    private   String endTime;

}
