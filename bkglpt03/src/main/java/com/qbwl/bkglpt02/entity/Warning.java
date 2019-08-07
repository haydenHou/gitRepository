package com.qbwl.bkglpt02.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author:Hayden
 * @Date:2019/7/16
 * 逆向报警
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Warning extends BaseEntity{
    private Short warnid;//序号
    private String warntype;//寄递类型
    private String warnname;//姓名
    private Short warnsex;//人员性别
    private String warncertcode;//证件号码
    private String remark;//
    private Short warnstatus;//状态
    private String warncontent;//详细情况
    private Long warndate;//录入日期
    private String warnprocuser;//处理人
    private String warnprocresult;//处理结果
    private Long warnprocdate;//处理日期
    private Integer warnsourcedict;//字典ID
    private String warnsourceid;//收寄或投递编号
    private Long taskid;


    public Warning(Short warnid, String warntype, String warnname, Short warnsex, String warncertcode, String remark, Short warnstatus, String warncontent, Long warndate, String warnprocuser, String warnprocresult, Long warnprocdate, Integer warnsourcedict, String warnsourceid, Long taskid) {
        this.warnid = warnid;
        this.warntype = warntype;
        this.warnname = warnname;
        this.warnsex = warnsex;
        this.warncertcode = warncertcode;
        this.remark = remark;
        this.warnstatus = warnstatus;
        this.warncontent = warncontent;
        this.warndate = warndate;
        this.warnprocuser = warnprocuser;
        this.warnprocresult = warnprocresult;
        this.warnprocdate = warnprocdate;
        this.warnsourcedict = warnsourcedict;
        this.warnsourceid = warnsourceid;
        this.taskid = taskid;
    }

    public Warning() {
        super();
    }



    @Override
    public String toString() {
        return "Warning{" +
                "warnid=" + warnid +
                ", warntype='" + warntype + '\'' +
                ", warnname='" + warnname + '\'' +
                ", warnsex=" + warnsex +
                ", warncertcode='" + warncertcode + '\'' +
                ", remark='" + remark + '\'' +
                ", warnstatus=" + warnstatus +
                ", warncontent='" + warncontent + '\'' +
                ", warndate=" + warndate +
                ", warnprocuser='" + warnprocuser + '\'' +
                ", warnprocresult='" + warnprocresult + '\'' +
                ", warnprocdate=" + warnprocdate +
                ", warnsourcedict=" + warnsourcedict +
                ", warnsourceid='" + warnsourceid + '\'' +
                ", taskid=" + taskid +
                '}';
    }
}