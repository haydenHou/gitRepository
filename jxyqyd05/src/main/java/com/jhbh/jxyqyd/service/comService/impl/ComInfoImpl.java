package com.jhbh.jxyqyd.service.comService.impl;

import com.jhbh.jxyqyd.commonenum.Dao_Type;
import com.jhbh.jxyqyd.commonenum.E_EconomicType;
import com.jhbh.jxyqyd.commonenum.Table_Name;
import com.jhbh.jxyqyd.commonenum.Table_Type;
import com.jhbh.jxyqyd.dao.ComInfoDao;
import com.jhbh.jxyqyd.entity.ComInfoTable;
import com.jhbh.jxyqyd.entity.PatternEntity;
import com.jhbh.jxyqyd.exception.ComExitException;
import com.jhbh.jxyqyd.exception.DataTooLongException;
import com.jhbh.jxyqyd.exception.InsertDataException;
import com.jhbh.jxyqyd.exception.UsernameConflictException;
import com.jhbh.jxyqyd.service.GBService.IGBComtypeService;
import com.jhbh.jxyqyd.service.GBService.IGbRegisterService;
import com.jhbh.jxyqyd.service.GBService.IGbXaRegisterService;
import com.jhbh.jxyqyd.service.comService.IComInfoService;
import com.jhbh.jxyqyd.utils.SqlToJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author:Hayden
 * @Date:2019/5/17
 */

@Service
public class ComInfoImpl implements IComInfoService {

    @Autowired
    ComInfoDao comInfoDao;

    @Autowired
    PatternEntity patternEntity;

    private final static String EXIT = "0";
    private final  static  String NO_PASS = "1";
    private final  static  String PASS = "2";





    @Override
    public void workReg(ComInfoTable comInfoTable, HttpServletRequest request, HttpServletResponse response) {
        /*
            如果该提交信息的营业执照为空，则允许提交
            如果不为空，判断其状态，如果是status是2，则该公司审核已经通过，如果status是1，则公司审核未通过
         */
        ComInfoTable comContions = getCnameByBusLicenceCode(comInfoTable.getBusLicenceCode());
        if(comContions == null){
            // 验证法人身份证号格式
            Pattern pattern;
            pattern = Pattern.compile(patternEntity.getIdcode());
            if(!pattern.matcher(comInfoTable.getLegPersonIdcode()).matches()) {
                throw new DataTooLongException("身份证格式不符");
            }
            // 验证邮箱格式
            pattern = Pattern.compile(patternEntity.getEmail());
            if(!pattern.matcher(comInfoTable.getEmail()).matches()){
                throw new DataTooLongException("邮箱格式不符");
            }
            // 验证电话格式
            pattern = Pattern.compile(patternEntity.getPhone());
            if(!pattern.matcher(comInfoTable.getContway()).matches()){
                throw new DataTooLongException("联系电话格式不符");
            }
            comInfoTable.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            comInfoTable.setStatus("0");
            comInfoTable.setAgencyName(xaRegisterService.gerAgency(comInfoTable.getAgency()).getAgencyName());
            if(!insertWorkInfo(comInfoTable)){
                throw new InsertDataException("公司申请信息提交失败");
            }
        }else if(NO_PASS.equals(comContions.getStatus())){
//            response.sendRedirect("qy/comInfoChange");
//            如果该企业信息存在，则转至企业信息更改
//            code 507
            throw new UsernameConflictException("该企业信息未通过审核");
        }else if(PASS.equals(comContions.getStatus())){
//            code 508
            throw new ComExitException("该企业信息已经通过审核");
        }else if(EXIT.equals(comContions.getStatus())){
            throw new ComExitException("该企业信息已经存在");
        }
    }

    @Override
    public String getCnameByCompanyCode(String companyCode) {
        return comInfoDao.getCnameByCompanyCode(companyCode);
    }

    @Override
    public ComInfoTable getCnameByBusLicenceCode(String busLicenceCode) {
        return comInfoDao.getCnameByBusLicenceCode(busLicenceCode);
    }

    @Override
    public Boolean insertWorkInfo(ComInfoTable comInfoTable) {
        Boolean aBoolean = comInfoDao.insertWorkInfo(comInfoTable);
        if(aBoolean){
            SqlToJsonUtil.addDaoData(Dao_Type.INSERT, Table_Name.com_info_table, Table_Type.ComInfoTable,comInfoTable);
        }
        return aBoolean;
    }

    @Override
    public ComInfoTable getComInfoByBusLicenceCode(String busLicenceCode) {
        ComInfoTable comInfo = comInfoDao.getComInfoByBusLicenceCode(busLicenceCode);
        if(comInfo.getEcotype()!=null){
            comInfo.setEcotype(E_EconomicType.getNameByCode(comInfo.getEcotype()));
        }
        return comInfo;
    }
    @Autowired
    IGbXaRegisterService xaRegisterService;
    @Autowired
    IGbRegisterService registerService;
    @Autowired
    IGBComtypeService comtypeService;

    @Override
    public ComInfoTable getComInfoByCompanyCode(ComInfoTable comInfoTable) {
        ComInfoTable comInfo = comInfoDao.getComInfoByCompanyCode(comInfoTable);
        if(comInfo != null){
            if(comInfo.getEcotype()!=null){
                comInfo.setEcotype(E_EconomicType.getNameByCode(comInfo.getEcotype()));
            }
            if(comInfo.getAgency() != null){
                comInfo.setAgency(xaRegisterService.gerAgency(comInfo.getAgency()).getAgencyName());
            }
            String register = comInfo.getRegister();
            if(register != null){
                comInfo.setRegister(registerService.getNameByCode(register).getDistrictName());
            }
            String companyType = comInfo.getCompanyType();
            if(companyType != null){
                comInfo.setCompanyType(comtypeService.getNameByCode(companyType).getTypeName());
            }
        }
        return comInfo;
    }

    @Override
    public Boolean changeWorkInfo(ComInfoTable comInfoTable) {
        comInfoTable.setStatus("0");
        comInfoTable.setModifiedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Boolean aBoolean = comInfoDao.changeWorkInfo(comInfoTable);
        if(aBoolean){
            SqlToJsonUtil.addDaoData(Dao_Type.UPDATE, Table_Name.com_info_table,Table_Type.ComInfoTable,comInfoTable);
        }
        return aBoolean;
    }


}
