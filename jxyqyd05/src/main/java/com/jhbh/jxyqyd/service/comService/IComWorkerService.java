package com.jhbh.jxyqyd.service.comService;

import com.jhbh.jxyqyd.entity.ComServiceWorkers;
import com.jhbh.jxyqyd.entity.ComUserTable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/17
 */
public interface IComWorkerService {


    /**
     * 根据用户名/contway查询用户登录信息
     * @param username username
     * @return  contway,`password`,maskcode,user_rank userRank,name,status
     */
    ComServiceWorkers getLoginInfoByUsername(String username);

    /**
     * 根据用户名获取用户所有信息
     * @param username 用户名
     * @return company_code companyCode,worker_code workerCode,`name`,sex,contway,`password`,maskcode,photo,now_address nowAddress,degree,idcode,register_address registerAddress,detail_address detailAddress,residence_permit residence_permit,entry,`leave`,`status`,create_time createTime
     */
    ComServiceWorkers getWorkerInfoByUsername(String username);

    /**
     * 根据工作人员编号查询信息
     * @param workerCode 员工编号
     * @return workerId
     */
    ComServiceWorkers getWorkerByWorkerCode(String workerCode);

    /**
     * 根据工作人员序列id查询信息
     * @param workerId 员工序列号
     * @return workerCode，contway
     */
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
     *  degree,idcode,registerAddress,,residencePermit,entry,status,createTime
     */
    void addComServiceWorker(ComServiceWorkers comServiceWorkers);

    /**
     *根据workerID更改用户信息
     * @param comServiceWorkers workerCode,name,sex,contway,photo,nowAddress,degree,idcode,registerAddress,residencePermit,modifiedTime,workerId
     */
    void changeWorkerInfoByWorkerId(ComServiceWorkers comServiceWorkers);

    /**
     * 根据用户名更改用户密码
     * @param comServiceWorkers password，maskcode,username
     */
    Boolean changePasswordByUsername(ComServiceWorkers comServiceWorkers);

    ComServiceWorkers doLogin(HttpServletRequest request, ComServiceWorkers user);

    Boolean changePassword(ComServiceWorkers workers, HttpServletRequest request);


    /**
     * 统计公司在职员工数
     * @param workers ompanyCode,status
     */
    Integer countWorker(ComServiceWorkers workers);

    ComServiceWorkers doLoginForPc(HttpServletRequest request, ComServiceWorkers user);
}
