package com.jhbh.jxyqyd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jhbh.jxyqyd.exception.DataTooLongException;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author:hou
 * @Date:2019/1/22
 * 2、企业端注册信息申请表（公安端 企业信息审批表）
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class  ComInfoTable extends BaseEntity {
    /**
     * 表单标识码(序号)
     */
    private Integer  comInfoId;
    /**
     * 企业代码(唯一标识) 13
     */
    private String   companyCode;
    /**
     * 企业分类(代码) 2
     */
    private String   companyType;
    /**
     * 行政区划     6
     */
    private String   register;
    /**
     * 企业名称
     */
    private String   cname;
    /**
     * 企业地址
     */
    private String   caddress;
    /**
     * 联系电话
     */
    private String   contway;
    /**
     * 传真
     */
    private String   fax;
    /**
     * 邮箱
     */
    private String   email;
    /**
     * 邮政编码 6
     */
    private String   postcode;
    /**
     *开业日期
     */
    private String   openDate;
    /**
     * 经济类型 3
     */
    private String   ecotype;
    /**
     * 法人代码 9
     */
    private String   legPersonCode;
    /**
     * 法定代表人
     */
    private String   legPerson;
    /**
     *法定代表人身份证号
     */
    private String   legPersonIdcode;
    /**
     * 治安负责人
     */
    private String   defPrincipal;
    /**
     * 保卫部门电话
     */
    private String   defDepartContway;
    /**
     * 经营范围
     */
    private String   businessScope;
    /**
     * 注册资本
     */
    private Double   registeredCapital;
    /**
     *占地面积
     */
    private Double   floorSpace;
    /**
     * 治安管理机构   13
     */
    private String   agency;
    /**
     *治安管理机构代码
     */
    private String   agencyName;
    /**
     * 特行备案编号
     */
    private String   specRecordCode;
    /**
     * 特行备案机构   12
     */
    private String   specRecordAgency;
    /**
     * 特行备案机构名称
     */
    private String   specRecordAname;
    /**
     * 行业许可证号
     */
    private String   induLicenceCode;
    /**
     * 行业许可证发证机构名称
     */
    private String   induLicenceAgency;
    /**
     * 企业统一社会信用代码
     */
    private String   unisocialCreditCode;
    /**
     * 企业统一社会信用发证机构
     */
    private String   unisocialLicenceAgency;
    /**
     * 营业执照编号
     */
    private String   busLicenceCode;
    /**
     * 营业执照发证机构名称
     */
    private String   busLicenceAgency;
    /**
     * 税务登记证编号
     */
    private String   taxLicenceCode;
    /**
     * 税务登记证发证机构名称
     */
    private String   taxLicenceAgency;
    /**
     * 目前状态  1
     */
    private String   status;
    /**
     * 备注
     */
    private String   remarks;
    /**
     * 表创建时间
     */
    private String   createTime;
    /**
     * 表修改时间
     */
    private String   modifiedTime;
    /**
     *  企业信息注销时间
     */
    private String   logoutTime;

    private String   startTime;
    private String   endTime;

    public ComInfoTable() {
    }



    public ComInfoTable(String cname, String caddress, String legPerson, String legPersonIdcode, String defPrincipal, String agency, String agencyName) {
        this.cname = cname;
        this.caddress = caddress;
        this.legPerson = legPerson;
        this.legPersonIdcode = legPersonIdcode;
        this.defPrincipal = defPrincipal;
        this.agency = agency;
        this.agencyName = agencyName;
    }







}
