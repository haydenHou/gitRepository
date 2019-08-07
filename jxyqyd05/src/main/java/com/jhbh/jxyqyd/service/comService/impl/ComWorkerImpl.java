package com.jhbh.jxyqyd.service.comService.impl;

import com.jhbh.jxyqyd.commonenum.E_EducationLevel;
import com.jhbh.jxyqyd.dao.ComWorkerDao;
import com.jhbh.jxyqyd.entity.ComServiceWorkers;
import com.jhbh.jxyqyd.exception.ChangeFailException;
import com.jhbh.jxyqyd.exception.InsertDataException;
import com.jhbh.jxyqyd.exception.PasswordNotMatchException;
import com.jhbh.jxyqyd.exception.UserNotFoundException;
import com.jhbh.jxyqyd.service.comService.IComWorkerService;
import com.jhbh.jxyqyd.utils.Md5Util;
import com.jhbh.jxyqyd.utils.ParametricSwitchUtil;
import com.jhbh.jxyqyd.utils.tokenUtils.TokenUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/5/17
 */
@Service
public class ComWorkerImpl implements IComWorkerService {

    @Autowired
    ComWorkerDao workerDao;

    /**
     * 表据创建或者更改时间的固定格式
     */
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 入职或离职时间的固定格式
     */
    private static final DateTimeFormatter ENTRY = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * 默认密码为123456
     */
    private final static String PASSWORD = "123456";
    /**
     * 默认状态为  在职  0
     */
    private final static String STATUS = "0";
    /**
     * 默认权限为  员工 1
     */
    private final static String USERRANK = "1";

    @Override
    public ComServiceWorkers doLogin(HttpServletRequest request, ComServiceWorkers user) {
        String username;
        String maskCode;
        ComServiceWorkers userInfo = getLoginInfoByUsername(user.getUsername());
        if(userInfo != null){
            maskCode = userInfo.getMaskcode();
            username = user.getUsername();
            // if(user.getPassword().equals(userInfo.getPassword())){
            return getComServiceWorkers(user, username, maskCode, userInfo);
        }else{
            throw new UserNotFoundException("用户名或密码不匹配");
        }
    }


    @Override
    public Boolean changePassword(ComServiceWorkers workers, HttpServletRequest request) {
        String username = TokenUtils.getUserNameOrRankFromJwt(request, 0);
        ComServiceWorkers loginInfo = getLoginInfoByUsername(username);
        // 判断输入的密码和原密码是否匹配
        if(Md5Util.MD5PR(workers.getOldPassword(),loginInfo.getMaskcode()).equals(loginInfo.getPassword())){
            // 判断新旧密码是否相同
            if(!workers.getOldPassword().equals(workers.getNewPassword())){
                String maskcode = Md5Util.md5(Md5Util.getRandomSalt());
                workers.setPassword(Md5Util.MD5PR(workers.getNewPassword(),maskcode));
                workers.setMaskcode(maskcode);
                workers.setUsername(username);
                workers.setModifiedTime(LocalDateTime.now().format(TIME_FORMATTER));
                return changePasswordByUsername(workers);
            }else{
                throw new PasswordNotMatchException("原密码与新密码不能相同");
            }
        }else{
            throw new PasswordNotMatchException("密码不匹配");
        }
    }


    @Override
    public ComServiceWorkers getLoginInfoByUsername(String username) {
        return workerDao.getLoginInfoByUsername(username);
    }

    @Override
    public ComServiceWorkers getWorkerInfoByUsername(String username) {

        ComServiceWorkers workerInfo = workerDao.getWorkerInfo(username);
        ParametricSwitchUtil.workerInfoSwitch(workerInfo);
        return workerInfo;
    }

    @Override
    public ComServiceWorkers getWorkerByWorkerCode(String workerCode) {
        return workerDao.getWorkerByWorkerCode(workerCode);
    }

    @Override
    public ComServiceWorkers getWorkerByWorkerId(String workerId) {
        return workerDao.getWorkerByWorkerId(workerId);
    }

    @Override
    public List<ComServiceWorkers> listWorkerByStatus(ComServiceWorkers comServiceWorkers) {
        List<ComServiceWorkers> workerByStatus = workerDao.listWorkerByStatus(comServiceWorkers);

        for (ComServiceWorkers c:workerByStatus) {
            ParametricSwitchUtil.workerInfoSwitch(c);
            if(c.getPhoto() == null){
                c.setPhoto("");
            }
            if(c.getLeave() == null){
                c.setLeave("");
            }
            if(c.getResidencePermit() == null){
                c.setResidencePermit("");
            }
        }
        return workerByStatus;
    }

    @Override
    public void addComServiceWorker(ComServiceWorkers comServiceWorkers) {
        comServiceWorkers.setCreateTime(LocalDateTime.now().format(TIME_FORMATTER));
        comServiceWorkers.setUsername(comServiceWorkers.getContway());

        String maskcode = Md5Util.md5(Md5Util.getRandomSalt());
        String password1 = Md5Util.MD5PR(PASSWORD, maskcode);

        comServiceWorkers.setPassword(password1);
        comServiceWorkers.setMaskcode(maskcode);
        comServiceWorkers.setStatus(STATUS);
        comServiceWorkers.setUserRank(USERRANK);
        if (!workerDao.addComServiceWorker(comServiceWorkers)) {
            throw  new InsertDataException("员工信息插入失败");
        }
    }

    @Override
    public void changeWorkerInfoByWorkerId(ComServiceWorkers comServiceWorkers) {
        comServiceWorkers.setModifiedTime(LocalDateTime.now().format(TIME_FORMATTER));
        comServiceWorkers.setUsername(comServiceWorkers.getContway());
        if (!workerDao.changeWorkerInfoByWorkerId(comServiceWorkers)) {
            throw  new ChangeFailException("员工信息更改失败");
        }
    }

    @Override
    public Boolean changePasswordByUsername(ComServiceWorkers comServiceWorkers) {
      return   workerDao.changePasswordByUsername(comServiceWorkers);
    }

    @Override
    public Integer countWorker(ComServiceWorkers workers) {
        return workerDao.countWorker(workers);
    }

    @Override
    public ComServiceWorkers doLoginForPc(HttpServletRequest request, ComServiceWorkers user) {
        String username;
        String maskCode;
        ComServiceWorkers userInfo = getLoginInfoByUsername(user.getUsername());
        if(userInfo != null){
            if("0".equals(userInfo.getUserRank())){
                maskCode = userInfo.getMaskcode();
                username = user.getUsername();
                // if(user.getPassword().equals(userInfo.getPassword())){
                return getComServiceWorkers(user, username, maskCode, userInfo);
            }else {
                throw new UserNotFoundException("没有该用户");
            }
        }else{
            throw new UserNotFoundException("用户名或密码不匹配");
        }
    }

    @NotNull
    private ComServiceWorkers getComServiceWorkers(ComServiceWorkers user, String username, String maskCode, ComServiceWorkers userInfo) {
        if (Md5Util.MD5PR(user.getPassword(), maskCode).equals(userInfo.getPassword())) {
            String jwtToken = TokenUtils.createJwtToken(username + "," + userInfo.getUserRank());
            ComServiceWorkers workerInfo = getWorkerInfoByUsername(username);
            workerInfo.setToken(jwtToken);

            ParametricSwitchUtil.workerInfoSwitch(workerInfo);

            return workerInfo;
        } else {
            throw new UserNotFoundException("用户名或密码不匹配");
        }
    }
}
