package com.jhbh.jxyqyd.controller;

import com.jhbh.jxyqyd.entity.ComInfoTable;
import com.jhbh.jxyqyd.exception.UserNotFoundException;
import com.jhbh.jxyqyd.responseResult.ResponseResult;
import com.jhbh.jxyqyd.service.comService.IComInfoService;
import com.jhbh.jxyqyd.utils.rankUtils.UserRank;
import com.jhbh.jxyqyd.utils.tokenUtils.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author:Hayden
 * @Date:2019/5/31
 * 处理企业注册
 */
@RestController
@RequestMapping("qy")
@CrossOrigin
public class ComInfoController extends BaseController {

    @Autowired
    IComInfoService comInfoService;


    /**
     * @param comInfoTable
     * companyCode,register,agencyName,workerCode,name,sex,contway,nowAddress,
     * degree,idcode,registerAddress,residencePermit,password,username,maskcode,
     * site_id,userRank,entry,status,createTime
     * @return
     */
    @PostMapping("workReg")
    public ResponseResult workReg(@RequestBody @Valid ComInfoTable comInfoTable, HttpServletRequest request, HttpServletResponse response){

        logParam(request.getRequestURL());
        logParam(comInfoTable);
        comInfoService.workReg(comInfoTable,request,response);
        return new ResponseResult();
    }

    /**
     * 根据企业代码查询企业信息
     * 供ios端展示企业信息
     * comInfoTable companyCode，userRank(并没有用到前端传来的，所用到的是直接从token中绑定的的userRank，用来确定用户权限)
     * @return 企业全部信息
     */
    @PostMapping("showComInfo")
    public ResponseResult showComInfo(HttpServletRequest request){
        String companyCode = getCompanyCodeByJwt(request);
        logParam(companyCode);
        ComInfoTable com = new ComInfoTable();
        com.setCompanyCode(companyCode);
        ComInfoTable comInfoByCompanyCode = comInfoService.getComInfoByCompanyCode(com);
        ResponseResult<ComInfoTable> rr = new ResponseResult<>();
        rr.setData(comInfoByCompanyCode);
        logParam(rr);
        return rr;
    }

    /**
     * 根据法人身份证和营业执照编号查询企业信息
     * 供pc端进行企业信息审核状态查询
     * @param comInfoTable busLicenceCode，legPersonIdCode
     * @return 所有企业信息
     * @throws IOException
     */
    @PostMapping("getWorkInfo")
    public ResponseResult<ComInfoTable> getComInfo(@RequestBody @Valid ComInfoTable comInfoTable) throws IOException {

        logParam(comInfoTable);
        ComInfoTable comInfo = comInfoService.getComInfoByBusLicenceCode(comInfoTable.getBusLicenceCode());
        ResponseResult<ComInfoTable> rr = new ResponseResult<>();
        if(comInfo == null){
            throw new UserNotFoundException("不存在该企业信息");
        }

        /**
         * busLicenceCode 用来查询，legPersonIdCode用来核实身份
         */
        if(comInfoTable.getLegPersonIdcode().equals(comInfo.getLegPersonIdcode())){
            rr.setData(comInfo);
        }else{
            throw new UserNotFoundException("信息不匹配");
        }
        return rr;
    }

    /**
     * 根据id更改企业信息
     * @param comInfoTable
     * companyType,register,cname,caddress,contway,fax,email,postcode,openDate,ecotype,
     * legPersonCode,legPerson,legPersonIdcode,defPrincipal,defDepartContway,businessScope,registeredCapital,floorSpace,agency,agencyName,
     * specRecordCode,specRecordAgency,specRecordAname,induLicenceCode,induLicenceAgency,unisocialCreditCode,unisocialLicenceAgency,busLicenceCode,busLicenceAgency,taxLicenceCode,
     * taxLicenceAgency,status,createTime
     * @param request
     * @return
     * @throws IOException
     */
    @UserRank
    @PostMapping("changeWorkInfo")
    @LoginRequired
    public ResponseResult changeWorkInfo(@RequestBody @Valid ComInfoTable comInfoTable, HttpServletRequest request) throws IOException {
        logParam(comInfoTable);
        comInfoService.changeWorkInfo(comInfoTable);
        return new ResponseResult();
    }





}
