package com.jhbh.jxyqyd.commonenum;

/**
 * @author:Hayden
 * @Date:2019/6/28
 */
public enum Table_Type {
    /**
     * 车辆信息
     * carInfoCase,carInfoConnect，carBusinessService，
     * carBusinessPartscarBusinessBeauty,carBusinessPark,
     * CarAddinfoAccident,CarAddinfoSuspicious
     */
    CarInfo,

    /**
     * 企业信息
     */
    ComInfoTable,

    /**
     * 企业更名表
     */
    ComInfoChange,

    /**
     * 员工信息表
     */
    ComServiceWorkers;


    Table_Type() {
    }





    @Override
    public String toString() {
        return super.toString();
    }
}
