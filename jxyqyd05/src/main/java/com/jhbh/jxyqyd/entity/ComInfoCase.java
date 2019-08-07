package com.jhbh.jxyqyd.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


/**
 * @Author:Hayden
 * @Date:2019/2/25
 * 3、企业案（事）件信息表
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComInfoCase extends BaseEntity{
      private Integer infoCaseId;             //    表单标识码(序号)      国标GA 435 3.1
      private String  companyCode;            //    企业代码(唯一标识)
      private String  cname;                  //  企业名称                varchar(40)
      private String  caseId;                 //    立案编号              表示：YYYYMMDDhhmm
      private String  caseTime;               //    发案时间
      private String  caseNature;             //    案(事)件性质           0、刑事案件  1、治安案件
      private String  caseType;               //    案(事)件类别           国标GA 240.1
      private String  describe;               //    情况描述
      private String  createTime;             //    创建时间              表示：YYYYMMDDhhmm
      private String  modifiedTime;           //    修改时间              表示:YYYYMMDDhhmm
      private String startTime;
      private String endTime;

}
