package com.jhbh.jxyqyd.controller;

import com.jhbh.jxyqyd.entity.ComServiceWorkers;
import com.jhbh.jxyqyd.exception.*;
import com.jhbh.jxyqyd.responseResult.ResponseResult;
import com.jhbh.jxyqyd.service.comService.IComWorkerService;
import com.jhbh.jxyqyd.utils.tokenUtils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:hou
 * @Date:2019/1/23
 */
public abstract class BaseController {
    /**
     * 日志打印
     */
    public static final Logger log = LoggerFactory.getLogger(BaseController.class.getName());

    @Autowired
    IComWorkerService workerService;

    // 判断异常的类型
    @ExceptionHandler(ServiceException.class)
    public ResponseResult<Void> handleException(Exception e){
        // 用户名冲突，例如注册时，用户名已经被占用
        if (e instanceof UsernameConflictException) {
            logException(400,e);
            return new ResponseResult<>(400, e);
            // 尝试访问的用户数据不存在
        } else if (e instanceof UserNotFoundException) {
            logException(401,e);
            return new ResponseResult<>(401, e);
            //密码不正确
        } else if (e instanceof PasswordNotMatchException) {
            logException(402,e);
            return new ResponseResult<>(402, e);
            //文件不能为空
        }else if(e instanceof MaterialNotNullException){
            logException(403,e);
            return new ResponseResult<>(403, e);
            //信息删除失败
        }else if(e instanceof  DeleteFailException){
            logException(405,e);
            return new ResponseResult<>(405, e);
            //邮件发送失败
        } else if(e instanceof MailSendingFaildException){
            logException(406,e);
            return new ResponseResult<>(406, e);
            //信息更改失败
        }else if(e instanceof ChangeFailException){
            logException(407,e);
            return new ResponseResult<>(407,e);
        }else if(e instanceof DataTooLongException){
            logException(408,e);
            return new ResponseResult<>(408,e);
        }else if(e instanceof TokenOutmodedException){
            logException(505,e);
            return new ResponseResult<>(505,e);
        }else if(e instanceof ComRegNoPassExcetion){
//            企业未通过审核，并跳转到企业信息更改页面
            return new ResponseResult<>(506,e);
        }else if(e instanceof ComExitException){
//            企业通过审核或者信息已经存在/跳转到登录页面
            return new ResponseResult<>(507,e);
        }
            // 其它可能遗漏没有处理的异常
            return new ResponseResult<>(408, e);
    }

    /**
     * 日志打印异常代码和异常说明
     * @param code 异常代码
     * @param e 异常详情
     */
    private void logException(Integer code,Exception e){
        log.error("异常代码:{}\t---异常详情:{}",code,e.getMessage());
    }

    /**
     * 打印反参
     * @param rr 结果集
     */
    void logParam(ResponseResult rr){
        log.info("返参:{}",rr.toString());
    }

    /**
     * 打印URL 和 入参
     * @param obj 入参
     */
    void logParam(Object obj){
        log.info("入参:{}",obj.toString());
    }

    /**
     * 通过request获取拆分后的servletPath
     * @return uri:eg-  showLogin
     */
    String getURI(HttpServletRequest request){
        return request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/")+1);
    }


    /**
     * 从jwt中获取绑定的username，再根据username查询companyCode
     * @param request 请求
     * @return companyCode
     */
    String getCompanyCodeByJwt(HttpServletRequest request){
        String userName = TokenUtils.getUserNameOrRankFromJwt(request,0);
        if(StringUtils.isNotEmpty(userName)){
            ComServiceWorkers workers = workerService.getLoginInfoByUsername(userName);
            return workers.getCompanyCode();
        }else{
            throw new UserNotFoundException("不存在该用户");
        }

    }
}
