package com.jhbh.jxyqyd.commonenum;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author:Hayden
 * @Date:2019/1/29
 */
public enum E_Rank {
    /**
     * 1
     *
     *
     * 0、省级            0、系统管理员
     * 1、市级            1、治安管理业务用户
     * 2、区级            2、查询用户
     * 3、派出所
     */
    PCSCX(3,2,"派出所级查询用户"),
    /**
     * 2  ;
     */
    PCSZAGL(3,1,"派出所级治安管理业务用户"),
    /**
     * 3  ;
     */
    PCSXTGL(3,0,"派出所级系统管理员"),
     /**
     * 4
     */
    QXJCX(2,2,"区县级查询用户"),
    /**
     * 5  ;
     */
    QXJZAGL(2,1,"区县级治安管理业务用户"),
    /**
     * 6  ;
     */
    QXJXTGL(2,0,"区县级系统管理员"),
    /**
     * 7
     */
    SHIJCX(1,2,"市级查询用户"),
    /**
     * 8  ;
     */
    SHIJZAGL(1,1,"市级治安管理业务用户"),
    /**
     * 9  ;
     */
    SHIJXTGL(1,0,"市级系统管理员"),
    /**
     * 10
     */
    SJCX(0,2,"省级查询用户"),
    /**
     * 11 ;
     */
    SJZAGL(0,1,"省级治安管理业务用户"),
    /**
     12 省级系统管理员;
     */
    SJXTGL(0,0,"省级系统管理员");



    private Integer agencyRank;
    private Integer userRank;
    private String name;

    E_Rank(Integer agencyRank,Integer userRank, String name) {
        this.agencyRank = agencyRank;
        this.userRank = userRank;
        this.name = name;
    }

    /**
     *根据管理机构权限和用户权限获取该用户的具体权限
     * @param agencyRank 管理机构权限
     * @param userRank 用户权限
     * @return agencyRank+userRank
     */
   public static Integer getRank(Integer agencyRank,Integer userRank){
       for (E_Rank r:E_Rank.values()) {
           if(agencyRank!=null && userRank!=null){
               if(r.agencyRank.equals(agencyRank)&&r.userRank.equals(userRank)){
                   return r.agencyRank+r.userRank;
               }
           }
       }
       return null;
   }

    /**
     *根据管理机构权限和用户权限获取该用户的具体权限
     * @param agencyRank 管理机构权限
     * @param userRank 用户权限
     * @return 权限名称
     */
    public static String getRankName(String agencyRank,String userRank){
        for (E_Rank r:E_Rank.values()) {
            if(StringUtils.isNotBlank(agencyRank)&& StringUtils.isNotBlank(userRank)){
                if(r.agencyRank.equals(agencyRank)&&r.userRank.equals(userRank)){
                    return r.name;
                }
            }
        }
        return null;
    }
    /**
     * 获取派出所权限
     * @param agencyRank 派出所权限
     */
    public static Integer getAgencyRank(String agencyRank){
        for (E_Rank r:E_Rank.values()) {
            if(r.agencyRank.equals(agencyRank)){
                return r.agencyRank;
            }
        }
        return null;
    }

    /**
     * 获取用户权限
     * @param userRank 用户权限
     */
    public static Integer getUserRank(Integer userRank){
        for (E_Rank r:E_Rank.values()) {
            if(r.userRank.equals(userRank)){
                return r.userRank;
            }
        }
        return null;
    }

}
