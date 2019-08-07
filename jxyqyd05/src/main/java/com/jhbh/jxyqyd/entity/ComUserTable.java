package com.jhbh.jxyqyd.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @Author:hou
 * @Date:2019/1/23
 * 企业用户登录表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComUserTable extends BaseEntity{

    /**
     * 表单标识码(序号)        int(11)
     */
    private Integer comUserId;

    /**
     * 企业代码(唯一标识)      varchar(13)
     */
    private String companyCode;

    /**
     * 照片
     */
    private String photo;

    /**
     * 员工代码 varchar（16）
     */
    private String workerCode;

    /**
     * 用户名 varchar(10)
     */
    private String username;

    /**
     * 密码  varchar(50)
     */
    private String password;

    /**
     *伪装标识(盐值)          varchar(50)
     */
    private String maskcode;

    /**
     *用户级别                varchar(1)
     */
    private String userRank;

    /**
     *登录地址标识            varchar(30)
     */
    private String siteId;

    /**
     * 令牌
     */
    private String token;

    /**
     *当前状态                varchar(1)
     */
    private String status;
    /**
     *最后登录时间            date
     */
    private String lastlogin;
    /**
     *表创建时间              date
     */
    private String createTime;
    /**
     *表修改时间              date
     */
    private String modifiedTime;

    /**
     *账号注销时间            date
     */
    private String logoutTime;

    /**
     *开始时间  用于区间查询
     */
    private String startTime;
    /**
     *结束时间 用于区间查询
     */
    private String endTime;


    public ComUserTable() {
    }

    public ComUserTable(String companyCode, String workerCode,String  photot, String username, String password, String maskcode, String userRank,String status,String createTime) {
        this.companyCode = companyCode;
        this.workerCode = workerCode;
        this.photo = photot;
        this.username = username;
        this.password = password;
        this.maskcode = maskcode;
        this.userRank = userRank;
        this.status = status;
        this.createTime = createTime;
    }
}
