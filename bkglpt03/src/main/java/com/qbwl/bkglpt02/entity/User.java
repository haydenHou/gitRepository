package com.qbwl.bkglpt02.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User extends BaseEntity{

    private String newPw;

    private String token;

    private String userid;

    private String username;

    private String userpw;

    private Date   userDate;

    private String department;

    private String company;

    private Short active;

    private Short fail;

    private Short userSuper;

    private Short userRank;

    public User(String userid, String username, String userpw, Date userDate, String department, String company, Short active, Short fail, Short userSuper, Short userRank) {
        this.userid = userid;
        this.username = username;
        this.userpw = userpw;
        this.userDate = userDate;
        this.department = department;
        this.company = company;
        this.active = active;
        this.fail = fail;
        this.userSuper = userSuper;
        this.userRank = userRank;
    }

    public User() {
        super();
    }


}