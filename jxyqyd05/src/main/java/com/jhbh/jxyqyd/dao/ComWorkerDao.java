package com.jhbh.jxyqyd.dao;

import com.jhbh.jxyqyd.entity.ComServiceWorkers;
import com.jhbh.jxyqyd.service.comService.IndexService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author:Hayden
 * @Date:2019/5/17
 * 处理员工信息表相关业务
 */
@Repository
public interface ComWorkerDao {

    /**
     * 根据用户名/username查询用户登录信息
     * @param username username
     * @return  contway,`password`,maskcode,user_rank userRank,`status`
     */
    @Select("SELECT contway,`password`,maskcode,user_rank userRank,`name`,company_code companyCode,`status` FROM com_service_workers WHERE username=#{username}")
    ComServiceWorkers getLoginInfoByUsername(String username);

    /**
     * 根据用户名获取用户所有信息
     * @param username 用户名
     * @return company_code companyCode,worker_code workerCode,`name`,sex,contway,`password`,maskcode,photo,now_address nowAddress,degree,idcode,register_address registerAddress,detail_address detailAddress,residence_permit residence_permit,entry,`leave`,`status`,create_time createTime
     */
    @Select("SELECT worker_id workerId,company_code companyCode,worker_code workerCode,`name`,sex,contway,username,`password`,photo,now_address nowAddress,degree,idcode,register_address registerAddress,detail_address detailAddress,residence_permit residencePermit,entry,`leave`,user_rank userRank,`status` FROM com_service_workers where username=#{username}")
    ComServiceWorkers getWorkerInfo(String username);

    /**
     * 根据工作人员编号查询信息
     * @param workerCode 员工编号
     * @return
     */
    @Select("SELECT worker_id workerId FROM com_service_workers where worker_code=#{workerCode}")
    ComServiceWorkers getWorkerByWorkerCode(String workerCode);

    /**
     * 根据工作人员序列id查询信息
     * @param workerId 员工序列号
     */
    @Select("SELECT worker_code workerCode,contway FROM com_service_workers where worker_id=#{workerId}")
    ComServiceWorkers getWorkerByWorkerId(String workerId);

    /**
     * 查询在职/离职员工信息
     * @param comServiceWorkers companyCode,status
     * @return status,name,contway
     */
    List<ComServiceWorkers> listWorkerByStatus(ComServiceWorkers comServiceWorkers);

    /**
     * 添加员工信息
     * @param comServiceWorkers
     *  companyCode,agencyName,workerCode,name,sex,contway,nowAddress,
     *  degree,idcode,registerAddress,,residencePermit,password,username,maskcode,site_id,userRank,entry,status,createTime
     * @return
     */
    @Insert("INSERT INTO com_service_workers " +
                    "(`company_code`,`agency_name`,`worker_code`,`name`,photo,`sex`,`contway`,`now_address`,`degree`,`idcode`,`register_address`," +
                    "`residence_permit`,password,username,maskcode,site_id,user_rank,`entry`,`status`,`create_time`) " +
            "VALUES " +
                    "(#{companyCode},#{agencyName},#{workerCode},#{name},#{photo},#{sex},#{contway},#{nowAddress},#{degree},#{idcode},#{registerAddress}," +
                    "#{residencePermit},#{password},#{username},#{maskcode},#{siteId},#{userRank},#{entry},#{status},#{createTime})")
    Boolean addComServiceWorker(ComServiceWorkers comServiceWorkers);

    /**
     *根据workerID更改用户信息
     * @param comServiceWorkers workerCode,name,sex,contway,photo,nowAddress,degree,idcode,registerAddress,residencePermit,modifiedTime,workerId
     * @return 成功返回true
     */
    @Update("UPDATE `jxy_data_db`.`com_service_workers` SET " +
                "`worker_code` = #{workerCode}, `name` = #{name}, `sex` = #{sex}, `photo` =#{photo},contway=#{contway},username=#{username}, " +
                "`now_address` =#{nowAddress}, `degree` =#{degree}, `idcode` =#{idcode}, `register_address` =#{registerAddress}, " +
                "`leave` = #{leave}, status=#{status}, `residence_permit` = #{residencePermit}, `modified_time` = #{modifiedTime} " +
            "WHERE " +
                "`worker_id` = #{workerId}")
    Boolean changeWorkerInfoByWorkerId(ComServiceWorkers comServiceWorkers);

    /**
     * 根据用户名更改用户密码
     * @param comServiceWorkers password，maskcode
     * @return 成功为true，失败为false
     */
    @Update("UPDATE com_service_workers SET " +
                "password=#{password},maskcode=#{maskcode} " +
            "WHERE " +
                "username = #{username}")
    Boolean changePasswordByUsername(ComServiceWorkers comServiceWorkers);

    /**
     * 统计公司在职员工数
     * @param workers ompanyCode,status
     */
    @Select("SELECT COUNT(*) FROM `jxy_data_db`.`com_service_workers` WHERE `company_code` = #{companyCode} AND `status` = '0'")
    Integer countWorker(ComServiceWorkers workers);



}
