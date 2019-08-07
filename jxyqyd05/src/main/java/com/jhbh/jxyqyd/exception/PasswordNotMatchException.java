package com.jhbh.jxyqyd.exception;

/**
 * @Author:hou
 * @Date:2018/12/24
 */

/**
 * 密码不匹配异常
 */
public class PasswordNotMatchException  extends ServiceException{
    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }
}
