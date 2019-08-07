package com.jhbh.jxyqyd.dao.gb;

import com.jhbh.jxyqyd.entity.GB.XaRegisterAgency;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/11
 */
@Repository
public interface GbXaRegisterTableDao {

    @Select("SELECT agency_code agencyCode,agency_name agencyName,district_code districtCode,district_rank districtRank FROM xa_register_agency where district_code = #{districtCode}")
    List<XaRegisterAgency> listXaRegister(String districtCode);

    @Select("SELECT agency_name agencyName FROM xa_register_agency WHERE agency_code = #{agencyCode}")
    XaRegisterAgency gerAgency(String agencyCode);


}
