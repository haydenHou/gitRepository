package com.jhbh.jxyqyd.service.comService;

import com.jhbh.jxyqyd.entity.ComInfoTable;
import org.apache.ibatis.annotations.Select;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/17
 */
public interface IComInfoService {


    /**
     * 根据企业代码查询企业名称
     * @param companyCode companyCode
     * @return cname
     */
    String getCnameByCompanyCode(String companyCode);


    /**
     * 根据营业执照查询该企业名称
     * @return Cname
     */
    ComInfoTable getCnameByBusLicenceCode(String busLicenceCode);

    /**
     * 企业注册业务处理
     * @param comInfoTable
     * @param request
     * @param response
     * @throws IOException
     */
    void workReg(ComInfoTable comInfoTable, HttpServletRequest request, HttpServletResponse response);

    /**
     * 企业注册信息添加
     * @param comInfoTable :
     *  companyType,register,cname,caddress,contway,fax,email,postcode,openDate,ecotype,
     *  legPersonCode,legPerson,legPersonIdcode,defPrincipal,defDepartContway,businessScope,registeredCapital,floorSpace,
     *  agency,agencyName,specRecordCode,specRecordAgency,specRecordAname,induLicenceCode,induLicenceAgency,
     *  unisocialCreditCode,unisocialLicenceAgency,busLicenceCode,busLicenceAgency,taxLicenceCode,taxLicenceAgency,status,createTime
     * @return 成功为true
     */
    Boolean insertWorkInfo(ComInfoTable comInfoTable);

    /**
     * 根据营营业执照获取企业信息
     * @param busLicenceCode 营业执照
     * @return 企业全部信息
     */
    ComInfoTable getComInfoByBusLicenceCode(String busLicenceCode);

    /**
     * 更改企业信息
     * @param comInfoTable
     *  companyType,register,cname,caddress,contway,fax,email,postcode,openDate,ecotype,
     *  legPersonCode,legPerson,legPersonIdcode,defPrincipal,defDepartContway,businessScope,registeredCapital,floorSpace,agency,agencyName,
     *  specRecordCode,specRecordAgency,specRecordAname,induLicenceCode,induLicenceAgency,unisocialCreditCode,unisocialLicenceAgency,busLicenceCode,busLicenceAgency,taxLicenceCode,
     *  taxLicenceAgency,status,createTime
     * @return 成功为true
     */
    Boolean changeWorkInfo(ComInfoTable comInfoTable);

    ComInfoTable getComInfoByCompanyCode(ComInfoTable comInfoTable);
}
