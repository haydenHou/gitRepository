package com.jhbh.jxyqyd.controller;

import com.github.pagehelper.Page;
import com.jhbh.jxyqyd.commonenum.E_EducationLevel;
import com.jhbh.jxyqyd.entity.ComInfoTable;
import com.jhbh.jxyqyd.entity.ComServiceWorkers;
import com.jhbh.jxyqyd.entity.PageEntity;
import com.jhbh.jxyqyd.entity.PatternEntity;
import com.jhbh.jxyqyd.exception.ChangeFailException;
import com.jhbh.jxyqyd.exception.DataTooLongException;
import com.jhbh.jxyqyd.exception.UsernameConflictException;
import com.jhbh.jxyqyd.responseResult.ResponseResult;
import com.jhbh.jxyqyd.service.comService.IComInfoService;
import com.jhbh.jxyqyd.service.comService.IComWorkerService;
import com.jhbh.jxyqyd.utils.GetIpUtils;
import com.jhbh.jxyqyd.utils.ftpUtils.FtpFileUploadService;
import com.jhbh.jxyqyd.utils.rankUtils.UserRank;
import com.jhbh.jxyqyd.utils.tokenUtils.CurrentUser;
import com.jhbh.jxyqyd.utils.tokenUtils.LoginRequired;
import com.jhbh.jxyqyd.utils.tokenUtils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/17
 */
@RestController
@RequestMapping("qy")
@LoginRequired
@CrossOrigin
public class ComWorkerController extends BaseController{

    @Autowired
    IComWorkerService workerService;
    @Autowired
    IComInfoService comInfoService;

    @Autowired
    FtpFileUploadService ftpFileUploadService;

    @Autowired
    PatternEntity patternEntity;



    /**
     * 处理登录请求
     * @param user  username，password
     * @return
     */
    @PostMapping("Login")
    public ResponseResult<ComServiceWorkers> doLogin(HttpServletRequest request, @CurrentUser @RequestBody @Valid ComServiceWorkers user){
        logParam(user);
        ComServiceWorkers workers = workerService.doLogin(request,user);
        ResponseResult<ComServiceWorkers> rr = new ResponseResult<>();
        rr.setData(workers);
        return rr;
    }

    /**
     * 处理登录请求
     * @param user  username，password
     * @return
     */
    @PostMapping("loginForPc")
    public ResponseResult<ComServiceWorkers> loginForPc(HttpServletRequest request, @CurrentUser @RequestBody @Valid ComServiceWorkers user){
        logParam(user);
        ComServiceWorkers workers = workerService.doLoginForPc(request,user);
        String cname = comInfoService.getCnameByCompanyCode(workers.getCompanyCode());
        ResponseResult<ComServiceWorkers> rr = new ResponseResult<>();
        workers.setCname(cname);
        rr.setData(workers);
        return rr;
    }

    /**
     *展示用户详细信息
     * @param user username用户名
     * @param request 请求
     * @return
     */
    @PostMapping("getWorkerInfo")
    public ResponseResult<ComServiceWorkers> getWorkerInfo(@RequestBody @Valid ComServiceWorkers user,HttpServletRequest request){
     logParam(user.getUsername());
        ResponseResult<ComServiceWorkers> rr  = new ResponseResult<>();
        ComServiceWorkers workerInfo = workerService.getWorkerInfoByUsername(user.getUsername());
        rr.setData(workerInfo);
        logParam(rr);
        return rr;
    }


    /**
     * 用户更改密码
     * @param workers oldPassword，newPassword,username
     * @return
     */
    @PostMapping("changePassword")
    public ResponseResult changPassword(@RequestBody @Valid ComServiceWorkers workers,HttpServletRequest request){
        logParam(workers);
        if (!workerService.changePassword(workers,request)) {
            throw new ChangeFailException("用户密码更改失败");
        }
        return new ResponseResult();
    }




    /**
     * 添加员工信息
     * @param workerCode 员工代码
     * @param name 姓名
     * @param sex 性别
     * @param contway 联系电话
     * @param nowAddress 现居地
     * @param degree 学历
     * @param idcode 身份证号
     * @param registerAddress 户籍所在地
     * @param residencePermit 居住证号
     * @throws IOException
     */
    @PostMapping("addComWorker")
    @UserRank
    public ResponseResult addWorker(
            @RequestParam("workerCode")      String workerCode,            @RequestParam("name") String name,
            @RequestParam("sex")             String sex,                   @RequestParam("contway") String contway,
            @RequestParam("nowAddress")      String nowAddress,            @RequestParam("degree") String degree,
            @RequestParam("idcode")          String idcode,                @RequestParam("registerAddress") String registerAddress,
            @RequestParam("entry")           String entry,                 String leave,String workerId,
            String residencePermit,
            HttpServletRequest request)  throws IOException {
        if(workerService.getWorkerByWorkerCode(workerCode)==null  ) {
            if(workerService.getLoginInfoByUsername(contway)==null) {
                    String companyCode = getCompanyCodeByJwt(request);
                    String photos = ftpFileUploadService.savePic(request).toString();
                    if(residencePermit == null){
                        residencePermit = "";
                    }
                    if(!idcode.matches(patternEntity.getIdcode())){
                        throw  new DataTooLongException("身份证格式不符");
                    }
                    if(photos == null ){
                        throw new DataTooLongException("头像不能为空");
                    }
                    ComServiceWorkers workers = new ComServiceWorkers(workerCode, photos, name, sex, contway, nowAddress, idcode, registerAddress, residencePermit);
                    if(E_EducationLevel.getCodeByName(degree)!=null){
                        workers.setDegree(E_EducationLevel.getCodeByName(degree));
                    }else if(E_EducationLevel.getNameByCode(degree)!=null){
                        workers.setDegree(degree);
                    }
                    workers.setCompanyCode(companyCode);
                    workers.setSiteId(GetIpUtils.getIpAddr(request));
                    workers.setEntry(entry);
                    workerService.addComServiceWorker(workers);
                    ResponseResult<String> rr = new ResponseResult<String>();
                    rr.setData("");
                    logParam(rr);
                return new ResponseResult();
            } else {
                throw new UsernameConflictException("该电话号码已经存在");
            }
        }else{
            throw  new UsernameConflictException("该员工编号已经存在");
        }
    }

    /**
     * 展示在职/离职员工信息
     * @param workers status
     * @return name,contway
     */
    @PostMapping("showWorker")
    @UserRank
    public ResponseResult<PageEntity> changeWorker (@RequestBody @Valid ComServiceWorkers workers, HttpServletRequest request){
        workers.setCompanyCode(getCompanyCodeByJwt(request));
        List<ComServiceWorkers> worker = workerService.listWorkerByStatus(workers);
        ResponseResult<PageEntity> rr = new ResponseResult<>();
        rr.setData(new PageEntity<>(worker));
        return rr;
    }

    /**
     * 更改员工信息
     * @param workerCode 员工编号
     * @param name 姓名
     * @param sex  性别
     * @param contway 联系方式
     * @param nowAddress 现居地
     * @param degree 学历
     * @param idcode 身份证号
     * @param registerAddress 户籍所在地
     * @param residencePermit 居住证号
     * @param workerId  员工序列号
     * @return 200,401,505
     * @throws IOException
     */
    @PostMapping("changeWorkerInfo")
    @UserRank
    public ResponseResult changeWorkerInfo(
            @RequestParam("workerCode")      String workerCode,            @RequestParam("name") String name,
            @RequestParam("sex")             String sex,                   @RequestParam("contway") String contway,
            @RequestParam("nowAddress")      String nowAddress,            @RequestParam("degree") String degree,
            @RequestParam("idcode")          String idcode,                @RequestParam("registerAddress") String registerAddress,
            String residencePermit,                                        @RequestParam("workerId") String workerId,
            String leave,
            HttpServletRequest request) throws IOException {
//      根据该用户序列号查询用户电话和员工编号
        ComServiceWorkers workerByWorkerId = workerService.getWorkerByWorkerId(workerId);
        System.out.println(workerByWorkerId);
//     如果输入的员工编号和最初的员工编号相同
//      或者
//     这个员工编号不存在，则通过
        if (workerCode.equals(workerByWorkerId.getWorkerCode())||workerService.getWorkerByWorkerCode(workerCode) == null) {

//         如果输入的电话号码和用户名相同
//         或者
//         该电话不存在，则通过
            if (contway.equals(workerByWorkerId.getContway())||workerService.getLoginInfoByUsername(contway)==null){
                String photos = ftpFileUploadService.savePic(request).toString();
//              如果上传了新图片，则更改原图片，如果没有上传新图片，则将原来图片再次覆盖
                ComServiceWorkers workers = new ComServiceWorkers(workerCode, photos, name, sex, contway, nowAddress,idcode, registerAddress, residencePermit);
                workers.setWorkerId(Integer.valueOf(workerId));
//              如果学历信息未发生改变，前端输入的信息不为代码，而是学历名称，需要更改为代码进行存储
//              如果发生了改变，则输入的就是代码，直接存储
                if(E_EducationLevel.getCodeByName(degree)!=null){
                    workers.setDegree(E_EducationLevel.getCodeByName(degree));
                }else if(E_EducationLevel.getNameByCode(degree)!=null){
                    workers.setDegree(degree);
                }
//              如果离职时间不为空，则判定该人员离职，则更改表中离职时间和在位状态
                if(StringUtils.isNotEmpty(leave)){
                    workers.setLeave(leave);
                    workers.setStatus("1");
                }else{
                    workers.setLeave(null);
                    workers.setStatus("0");
                }
                workerService.changeWorkerInfoByWorkerId(workers);
                return new ResponseResult();
            } else {
                throw new UsernameConflictException("该电话号码已经存在");
            }
        } else {
            throw new UsernameConflictException("该员工编号已经存在");
        }
    }
}
