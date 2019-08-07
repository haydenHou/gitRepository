package com.qbwl.bkglpt02.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BDZTRY {
    private String rybh;
    private String jz;
    private String Xm;
    private String bmch;
    private String xb;
    private String csrq;
    private String csrqsx;
    private String sfzh;
    private String hjdqh;
    private String hjdxz;
    private String xzdqh;
    private String xzdxz;
    private String qtzj1m;
    private String qtzj1h;
    private String qtzj2m;
    private String qtzj2h;
    private String sf;
    private Short  sg;
    private String lx;
    private String tx;
    private String ky;
    private String qtzj1bw;
    private String tbbj1fw;
    private String tbbj1sl;
    private String tbbj1bj;
    private String tbbj2bw;
    private String tbbj2fw;
    private String tbbj2sl;
    private String tbbj2bj;
    private String tbbj3bw;
    private String tbbj3fw;
    private String tbbj3sl;
    private String tbbj3bj;
    private String tstz1;
    private String tstz2;
    private String tstz3;
    private String ajbh;

    private String ajlb;

    private String sh;

    private String ztlx;

    private String jyaq;

    private String tprq;

    private String tpfx;

    private String flsd;

    private String dbjb;

    private String tjljb;

    private String jj;

    private String tjrq;

    private String tjdwqh;

    private Short tjnd;

    private String tjsxh;

    private String tjjb;

    private String ladwqh;

    private String ladwxc;

    private String zbr;

    private String lxfs;

    private String djrq;

    private String djr;

    private String status;

    public BDZTRY() {
    }

    public BDZTRY(String rybh, String jz, String xm, String bmch, String xb, String csrq, String csrqsx, String sfzh, String hjdqh, String hjdxz, String xzdqh, String xzdxz, String qtzj1m, String qtzj1h, String qtzj2m, String qtzj2h, String sf, Short sg, String lx, String tx, String ky, String qtzj1bw, String tbbj1fw, String tbbj1sl, String tbbj1bj, String tbbj2bw, String tbbj2fw, String tbbj2sl, String tbbj2bj, String tbbj3bw, String tbbj3fw, String tbbj3sl, String tbbj3bj, String tstz1, String tstz2, String tstz3, String ajbh, String ajlb, String sh, String ztlx, String jyaq, String tprq, String tpfx, String flsd, String dbjb, String tjljb, String jj, String tjrq, String tjdwqh, Short tjnd, String tjsxh, String tjjb, String ladwqh, String ladwxc, String zbr, String lxfs, String djrq, String djr, String status) {
        this.rybh = rybh;
        this.jz = jz;
        Xm = xm;
        this.bmch = bmch;
        this.xb = xb;
        this.csrq = csrq;
        this.csrqsx = csrqsx;
        this.sfzh = sfzh;
        this.hjdqh = hjdqh;
        this.hjdxz = hjdxz;
        this.xzdqh = xzdqh;
        this.xzdxz = xzdxz;
        this.qtzj1m = qtzj1m;
        this.qtzj1h = qtzj1h;
        this.qtzj2m = qtzj2m;
        this.qtzj2h = qtzj2h;
        this.sf = sf;
        this.sg = sg;
        this.lx = lx;
        this.tx = tx;
        this.ky = ky;
        this.qtzj1bw = qtzj1bw;
        this.tbbj1fw = tbbj1fw;
        this.tbbj1sl = tbbj1sl;
        this.tbbj1bj = tbbj1bj;
        this.tbbj2bw = tbbj2bw;
        this.tbbj2fw = tbbj2fw;
        this.tbbj2sl = tbbj2sl;
        this.tbbj2bj = tbbj2bj;
        this.tbbj3bw = tbbj3bw;
        this.tbbj3fw = tbbj3fw;
        this.tbbj3sl = tbbj3sl;
        this.tbbj3bj = tbbj3bj;
        this.tstz1 = tstz1;
        this.tstz2 = tstz2;
        this.tstz3 = tstz3;
        this.ajbh = ajbh;
        this.ajlb = ajlb;
        this.sh = sh;
        this.ztlx = ztlx;
        this.jyaq = jyaq;
        this.tprq = tprq;
        this.tpfx = tpfx;
        this.flsd = flsd;
        this.dbjb = dbjb;
        this.tjljb = tjljb;
        this.jj = jj;
        this.tjrq = tjrq;
        this.tjdwqh = tjdwqh;
        this.tjnd = tjnd;
        this.tjsxh = tjsxh;
        this.tjjb = tjjb;
        this.ladwqh = ladwqh;
        this.ladwxc = ladwxc;
        this.zbr = zbr;
        this.lxfs = lxfs;
        this.djrq = djrq;
        this.djr = djr;
        this.status = status;
    }
}