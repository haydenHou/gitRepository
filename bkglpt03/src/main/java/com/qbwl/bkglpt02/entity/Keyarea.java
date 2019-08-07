package com.qbwl.bkglpt02.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Keyarea {
    private BigDecimal kaid;

    private String kaword;

    private String kamark;

    private String katype;

    private String kauser;

    private String kaalert;

    private BigDecimal kanum;

    private String kasecurityorg;

    private BigDecimal kainfotype;

    private BigDecimal kadate;

    public Keyarea(BigDecimal kaid, String kaword, String kamark, String katype, String kauser, String kaalert, BigDecimal kanum, String kasecurityorg, BigDecimal kainfotype, BigDecimal kadate) {
        this.kaid = kaid;
        this.kaword = kaword;
        this.kamark = kamark;
        this.katype = katype;
        this.kauser = kauser;
        this.kaalert = kaalert;
        this.kanum = kanum;
        this.kasecurityorg = kasecurityorg;
        this.kainfotype = kainfotype;
        this.kadate = kadate;
    }

    public Keyarea() {
        super();
    }

}