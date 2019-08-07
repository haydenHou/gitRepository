package com.qbwl.bkglpt02.controller;


import com.qbwl.bkglpt02.commonenum.E_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qbwl.bkglpt02.exception.*;
import com.qbwl.bkglpt02.responseResult.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:hou
 * @Date:2019/1/23
 */
@RestControllerAdvice
public abstract class BaseController {
    /**
     * 日志打印
     */
    public static final Logger log = LoggerFactory.getLogger(BaseController.class.getName());


    /**
     * 统一捕获异常
     * @param e 异常类型
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseResult<Void> handleException(Exception e){

        if(e instanceof UsernameConflictException) {
            return new ResponseResult<>(E_EXCEPTION.USER_CONFIG.getCode(),e);
        }else if (e instanceof UserNotFoundException) {
            return new ResponseResult<>(E_EXCEPTION.USER_NOT_FOUND.getCode(),e);
        }else if (e instanceof PasswordNotMatchException) {
            return new ResponseResult<>(E_EXCEPTION.PW_NOMATCH.getCode(),e);
        }else if(e instanceof MaterialNullException){
            return new ResponseResult<>(403,e);
        }else if(e instanceof MailSendingFaildException){
            return new ResponseResult<>(406,e);
        }else if(e instanceof DataFormatException){
            return new ResponseResult<>(E_EXCEPTION.PARAM_FORMAT.getCode(),e);
        }else if(e instanceof TokenOutmodedException){
            return new ResponseResult<>(E_EXCEPTION.TOKEN_OUTMODED.getCode(),e);
        }else if(e instanceof ComRegNoPassExcetion){
            return new ResponseResult<>(506,e);
        }else if(e instanceof ComExitException){
            return new ResponseResult<>(507,e);
        }else if(e instanceof InsertFailException){
            return new ResponseResult<>(E_EXCEPTION.INSERT_FAIL.getCode(),e);
        }else if(e instanceof UpdateFailException){
            return new ResponseResult<>(E_EXCEPTION.UPDATE_FAILE.getCode(),e);
        }else if(e instanceof DeleteFailException){
            return new ResponseResult<>(E_EXCEPTION.DELET_FAIL.getCode(),e);
        }else if(e instanceof NoResultException){
            return new ResponseResult<>(E_EXCEPTION.NO_RESULT.getCode(),e);
        }
            return new ResponseResult<>(606,e);
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
     * 入参
     * @param obj 入参
     */
    void logParam(Object obj){
        log.info("入参:{}",obj.toString());
    }

    /**
     * 打印URL 和 入参
     * @param object 入参
     */
    void logParam(HttpServletRequest request,Object object){
        log.info("URL:{}__入参:{}",request.getRequestURL(),object);
    }

    /**
     * 通过request获取拆分后的servletPath
     * @return uri:eg-  showLogin
     */
    String getURI(HttpServletRequest request){
        return request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/")+1);
    }

}
