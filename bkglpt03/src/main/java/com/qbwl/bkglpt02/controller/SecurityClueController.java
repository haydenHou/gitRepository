package com.qbwl.bkglpt02.controller;

import com.qbwl.bkglpt02.entity.SecurityClue;
import com.qbwl.bkglpt02.responseResult.ResponseResult;
import com.qbwl.bkglpt02.service.ISecurityClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/16
 */
@RestController
@CrossOrigin
@RequestMapping("bkgl")
public class SecurityClueController extends BaseController{

    @Autowired
    ISecurityClueService clueService;

    /**
     * 新增线索上报信息
//     TODO 有图片，需要调整为表单提交
     * @param record
     *   scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *   scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     */
    @PostMapping("insertSecurityClue")
    public ResponseResult insert(@RequestBody @Valid SecurityClue record, HttpServletRequest request){
        logParam(request,record);
        clueService.insert(record);
        return new ResponseResult();
    }

    /**
     * 根据scid查询详细信息
     * @param record  获取scid
     * @return
     *   scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *   scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     */
    @PostMapping("getSecurityByPrimaryKey")
    public ResponseResult<SecurityClue> selectByPrimaryKey(@RequestBody @Valid SecurityClue record, HttpServletRequest request){
        logParam(request,record);
        SecurityClue securityClue = clueService.selectByPrimaryKey(record.getScid());
        ResponseResult<SecurityClue> rr = new ResponseResult<>();
        rr.setData(securityClue);
        logParam(rr);
        return rr;
    }

    /**
     *  根据 线索编码，线索类型，上报企业，上报人，上报人电话，上报日期，处理状态为条件模糊查询上报信息
     * @param record  scid,scgoods,sccompany,scpeople,scmp,sccreatetime,scprocstatus
     * @return
     *   scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *   scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     */
    @PostMapping("listSecurityBySelective")
    public ResponseResult<List<SecurityClue>> listBySelective(@RequestBody @Valid SecurityClue record, HttpServletRequest request){
        logParam(request,record);
        List<SecurityClue> securityClues = clueService.listBySelective(record);
        ResponseResult<List<SecurityClue>> rr = new ResponseResult<>();
        rr.setData(securityClues);
        logParam(rr);
        return rr;
    }

    /**
     * 根据scid选择性更改信息
     * @param record
     *    scid, scgoods, sccompany, scpeople, scmp, scaddress, scsketch, sccreatetime, scbillcode,scimg,screcetime,
     *    scsendtime, scdeletetime, scupdatetime, sclng, sclat, scprocuser,scprocdate,scprocresult, scprocstatus, sctypeid
     * @return 成功返回1，失败返回0
     */
    @PostMapping("updateSecurityClueBySelective")
    public ResponseResult updateSecurityClueBySelective(@RequestBody @Valid SecurityClue record, HttpServletRequest request){
        logParam(request,record);
        clueService.updateByPrimaryKeySelective(record);
        return new ResponseResult();
    }


    @PostMapping("delSecurityClue")
    public ResponseResult delSecurityClue(@RequestBody @Valid SecurityClue record, HttpServletRequest request){
        logParam(request,record);
        clueService.deleteByPrimaryKey(record.getScid());
        return new ResponseResult();
    }












}
