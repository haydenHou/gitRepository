package com.qbwl.bkglpt02.service;

import com.qbwl.bkglpt02.entity.SecurityClue;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/16
 */
public interface ISecurityClueService {

    /**
     * 根据scid 删除 对应参数
     * @param scid 序列id
     * @return 成功返回1，失败为0
     */
    int deleteByPrimaryKey(String scid);

    /**
     * 新增线索上报信息
     * @param record
     *      scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *      scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     * @return 成功为1，失败为0
     */
    int insert(SecurityClue record);

    /**
     * 选择性插入信息（可为空）
     * @param record
     *      scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *      scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     * @return 成功为1，失败为0
     */
    int insertSelective(SecurityClue record);

    /**
     * 根据scid查询详细信息
     * @param scid 序列id
     * @return
     *   scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *   scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     */
    SecurityClue selectByPrimaryKey(String scid);

    /**
     * 根据 线索编码，线索类型，上报企业，上报人，上报人电话，上报日期，处理状态为条件模糊查询上报信息
     * @param record  scid,scgoods,sccompany,scpeople,scmp,sccreatetime,scprocstatus
     * @return
     *    scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *    scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     */
    List<SecurityClue> listBySelective(SecurityClue record);

    /**
     * 根据scid选择性更改信息
     * @param record
     *     scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *     scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     * @return 成功返回1，失败返回0
     */
    int updateByPrimaryKeySelective(SecurityClue record);

    /**
     * 根据scid更改全部信息
     * @param record
     *      scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *      scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     * @return 成功返回1 失败为0
     */
    int updateByPrimaryKey(SecurityClue record);
}
