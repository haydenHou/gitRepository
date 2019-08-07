package com.jhbh.jxyqyd.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
@Data
public abstract class BaseEntity {


    public String  cname;                     //企业名称
    public Integer moduleId;                  //模块Id
    public String  startTime;                  //开始时间
    public String  endTime;                    // 结束时间
    public String  username;
    public String  userRank;
    public Integer timeZone;                    //时间段

    //分页大小
    private Integer pageSize;
    //分页开始
    private Integer pageNum;

    private Integer total;

    //排序类型DESC  or  AES
    private String sort;

    private String orderBy;




    @JSONField(serialize = false)
    public Integer getPageSize() {
        return pageSize;
    }


    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @JSONField(serialize = false)
    public Integer getPageNum() {
        return pageNum;
    }


    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @JSONField(serialize = false)
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @JSONField(serialize = false)
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @JSONField(serialize = false)
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
