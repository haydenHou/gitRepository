package com.qbwl.bkglpt02.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hayden
 * @Date:2019/7/16
 * 线索上报
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityClue extends BaseEntity{

    private String scid;//线索编码
    private String scgoods;//可疑物品
    private String sccompany;//上报企业
    private String scpeople;//上报人员
    private String scmp;    //联系电话
    private String scaddress;//上报地址
    private String scsketch;//线索简述
    private Long   sccreatetime;//上报日期
    private String scbillcode;//运单编号
    private String scimg;//上报图片
    private Long   screcetime;//收到时间
    private Long   scsendtime;//发送时间
    private Long   scdeletetime;//删除时间
    private Long   scupdatetime;//更新时间
    private BigDecimal sclng;//经度
    private BigDecimal sclat;//纬度
    private String scprocuser;
    private Long scprocdate;
    private String scprocresult;
    private Long scprocstatus;//是否处理
    private Short sctypeid;

    public SecurityClue(String scid, String scgoods, String sccompany, String scpeople, String scmp, String scaddress, String scsketch, Long sccreatetime, String scbillcode, String scimg, Long screcetime, Long scsendtime, Long scdeletetime, Long scupdatetime, BigDecimal sclng, BigDecimal sclat, String scprocuser, Long scprocdate, String scprocresult, Long scprocstatus, Short sctypeid) {
        this.scid = scid;
        this.scgoods = scgoods;
        this.sccompany = sccompany;
        this.scpeople = scpeople;
        this.scmp = scmp;
        this.scaddress = scaddress;
        this.scsketch = scsketch;
        this.sccreatetime = sccreatetime;
        this.scbillcode = scbillcode;
        this.scimg = scimg;
        this.screcetime = screcetime;
        this.scsendtime = scsendtime;
        this.scdeletetime = scdeletetime;
        this.scupdatetime = scupdatetime;
        this.sclng = sclng;
        this.sclat = sclat;
        this.scprocuser = scprocuser;
        this.scprocdate = scprocdate;
        this.scprocresult = scprocresult;
        this.scprocstatus = scprocstatus;
        this.sctypeid = sctypeid;
    }

    public SecurityClue() {
        super();
    }





}