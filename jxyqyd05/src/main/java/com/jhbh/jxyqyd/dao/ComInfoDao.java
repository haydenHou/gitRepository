package com.jhbh.jxyqyd.dao;

import com.jhbh.jxyqyd.entity.ComInfoTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/17
 * 企业信息相关业务
 */
@Repository
public interface ComInfoDao {

    /**
     * 根据企业代码查询企业名称
     * @param companyCode companyCode
     * @return cname
     */
    @Select("SELECT cname FROM com_info_table WHERE company_code=#{companyCode} AND `status`='2'")
    String getCnameByCompanyCode(String companyCode);

    /**
     * 根据营业执照查询该企业名称
     * @param busLicenceCode 营业执照编号
     * @return Cname
     */
    @Select("SELECT cname,status,com_info_id comInfoId FROM com_info_table WHERE bus_licence_code =#{busLicenceCode}" )
    ComInfoTable getCnameByBusLicenceCode(String busLicenceCode);

    /**
     * 企业注册信息添加
     *  companyType,register,cname,caddress,contway,fax,email,postcode,openDate,ecotype,
     *  legPersonCode,legPerson,legPersonIdcode,defPrincipal,defDepartContway,businessScope,registeredCapital,floorSpace,agency,agencyName,
     *  specRecordCode,specRecordAgency,specRecordAname,induLicenceCode,induLicenceAgency,unisocialCreditCode,unisocialLicenceAgency,busLicenceCode,busLicenceAgency,taxLicenceCode,
     *  taxLicenceAgency,status,createTime
     * @return 成功为true
     */
    @Insert("INSERT INTO " +
            "`jxy_data_db`.`com_info_table`" +
                "(company_type,register,cname,caddress,contway,fax,email,postcode,open_date,ecotype," +
                "leg_person_code,leg_person,leg_person_idcode,def_principal,def_depart_contway,business_scope,registered_capital," +
                "floor_space,agency,agency_name,spec_record_code,spec_record_agency,spec_record_aname,indu_licence_code,indu_licence_agency," +
                "unisocial_credit_code,unisocial_licence_agency,bus_licence_code,bus_licence_agency,tax_licence_code,tax_licence_agency,status,create_time) " +
            "VALUES " +
                "(#{companyType},#{register},#{cname},#{caddress},#{contway},#{fax},#{email},#{postcode},#{openDate},#{ecotype}," +
                "#{legPersonCode},#{legPerson},#{legPersonIdcode},#{defPrincipal},#{defDepartContway},#{businessScope},#{registeredCapital},#{floorSpace}," +
                "#{agency},#{agencyName},#{specRecordCode},#{specRecordAgency},#{specRecordAname},#{induLicenceCode},#{induLicenceAgency}," +
                "#{unisocialCreditCode},#{unisocialLicenceAgency},#{busLicenceCode},#{busLicenceAgency},#{taxLicenceCode},#{taxLicenceAgency},#{status},#{createTime})")
    Boolean insertWorkInfo(ComInfoTable comInfoTable);


    /**
     * 根据营营业执照获取企业信息
     * @param busLicenceCode 营业执照
     */
    @Select("SELECT  " +
                "com_info_id comInfoId,company_type companyType,cname,caddress,contway,fax,email,postcode,open_date openDate,ecotype,"+
                "leg_person_code legPersonCode,leg_person legPerson,leg_person_idcode legPersonIdcode,def_principal defPrincipal,def_depart_contway defDepartContway," +
                "business_scope businessScope,registered_capital registeredCapital,floor_space floorSpace,agency,agency_name agencyName,spec_record_code specRecordCode," +
                "spec_record_agency specRecordAgency,spec_record_aname specRecordAname,indu_licence_code induLicenceCode,indu_licence_agency induLicenceAgency,"+
                "unisocial_credit_code unisocialCreditCode,unisocial_licence_agency unisocialLicenceAgency,bus_licence_code busLicenceCode,bus_licence_agency busLicenceAgency," +
                "tax_licence_code taxLicenceCode,tax_licence_agency taxLicenceAgency,status,remarks,create_time  createTime " +
            "FROM  " +
                "com_info_table " +
            "WHERE " +
                "bus_licence_code = #{busLicenceCode}")
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
    @Update("UPDATE `jxy_data_db`.`com_info_table` SET " +
                "`company_type` = #{companyType}, `register` = #{register}, `cname` = #{cname}, `caddress` = #{caddress},`contway` = #{contway}," +
                "`fax` = #{fax}, `email` = #{email}, `postcode` = #{postcode}, `open_date` = #{openDate},`ecotype` = #{ecotype}," +
                "`leg_person_code` = #{legPersonCode},`leg_person` =#{legPerson}, `leg_person_idcode` = #{legPersonIdcode},`business_scope` = #{businessScope}, `registered_capital` = #{registeredCapital}, " +
                "`floor_space` = #{floorSpace}, `agency` = #{agency}, `agency_name` = #{agencyName}, `spec_record_code` = #{specRecordCode}, `spec_record_agency` = #{specRecordAgency}, " +
                "`spec_record_aname` = #{specRecordAname}, `indu_licence_code` = #{induLicenceCode}, `indu_licence_agency` = #{induLicenceAgency}, `unisocial_credit_code` = #{unisocialCreditCode},`unisocial_licence_agency` = #{unisocialLicenceAgency}," +
                "`bus_licence_code` = #{busLicenceCode}, `bus_licence_agency` = #{busLicenceAgency}, `tax_licence_code` = #{taxLicenceCode}, `tax_licence_agency` = #{taxLicenceAgency},`status` = #{status}," +
                "`remarks` = #{remarks},`modified_time` = #{modifiedTime} " +
            "WHERE " +
                "`com_info_id` = #{comInfoId}")
    Boolean changeWorkInfo(ComInfoTable comInfoTable);


    /**
     * 根据企业代码查询企业信息
     * @param comInfoTable companyCode
     */
    @Select("SELECT  " +
                "com_info_id comInfoId,company_code companyCode,company_type companyType,register,cname,caddress,contway,fax,email,postcode,open_date openDate,ecotype,"+
                "leg_person_code legPersonCode,leg_person legPerson,leg_person_idcode legPersonIdcode,def_principal defPrincipal,def_depart_contway defDepartContway," +
                "business_scope businessScope,registered_capital registeredCapital,floor_space floorSpace,agency,agency_name agencyName,spec_record_code specRecordCode," +
                "spec_record_agency specRecordAgency,spec_record_aname specRecordAname,indu_licence_code induLicenceCode,indu_licence_agency induLicenceAgency,"+
                "unisocial_credit_code unisocialCreditCode,unisocial_licence_agency unisocialLicenceAgency,bus_licence_code busLicenceCode,bus_licence_agency busLicenceAgency," +
                "tax_licence_code taxLicenceCode,tax_licence_agency taxLicenceAgency,status,remarks,create_time  createTime " +
            "FROM  " +
                "com_info_table " +
            "WHERE " +
                "company_code = #{companyCode} and status = 2")
    ComInfoTable getComInfoByCompanyCode(ComInfoTable comInfoTable);
}
