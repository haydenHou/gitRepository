package com.jhbh.jxyqyd.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Objects;

/**
 * @Author:Hayden
 * @Date:2019/3/12
 *
 * 2、从业人员信息表
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComServiceWorkers extends BaseEntity{

  private Integer workerId;             //表单标识码(序号)
  private String companyCode;           //企业代码(唯一标识)
  private String agencyName;            //管理机构名称
  private String workerCode;            //企业人员内部编号
  private String photo;
  private String name;                  //姓名

  private String sex;                   //性别
  private String sexN;

  private String contway;               //联系电话
  private String nowAddress;

  private String degree;                //文化程度
  private String degreeN;

  private String idcode;                //公民身份号码
  /**
   * 户口所在地
   */
  private String registerAddress;
  /**
   * 详址
   */
  private String detailAddress;
  /**
   * 居住证号
   */
  private String residencePermit;
  /**
   * 培训经历
   */
  private String trainExperience;
  /**
   * 培训证书编号
   */
  private String certificateNumber;
  /**
   * 培训资料数据
   */
  private String trainData;
  /**
   * 入职日期
   */
  private String entry;
  /**
   * 离职日期
   */
  private String leave;
  /**
   * 当前状态
   */
  private String status;
  /**
   * 创建时间
   */
  private String createTime;

  /**
   * 修改时间
   */
  private String modifiedTime;
  /**
   * 注销时间
   */
  private String logoutTime;
  /**
   * 登录标识
   */
  private String siteId;
  /**
   * 用户名
   */
  private String username;
  /**
   * 用户权限
   */
  private String userRank;
  /**
   * 用户密码
   */
  private String password;
  /**
   * 加密盐值
   */
  private String maskcode;
  /**
   * token
   */
  private String token;
  /**
   *
   */
  private String cname;


  private String startTime;
  private String endTime;
  private String oldPassword;
  private String newPassword;


  public ComServiceWorkers() {

  }



  public ComServiceWorkers(String workerCode, String photo, String name, String sex, String contway, String nowAddress, String idcode,String registerAddress, String residencePermit) {
    this.workerCode = workerCode;
    this.photo = photo;
    this.name = name;
    this.sex = sex;
    this.contway = contway;
    this.nowAddress = nowAddress;
    this.idcode = idcode;
    this.registerAddress = registerAddress;
    this.residencePermit = residencePermit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o){
      return true;
    }
    if (!(o instanceof ComServiceWorkers)){
      return false;
    }
    ComServiceWorkers workers = (ComServiceWorkers) o;
    return Objects.equals(agencyName, workers.agencyName) &&
            Objects.equals(workerCode, workers.workerCode) &&
            Objects.equals(name, workers.name) &&
            Objects.equals(contway, workers.contway);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agencyName, workerCode, name, contway);
  }
}
