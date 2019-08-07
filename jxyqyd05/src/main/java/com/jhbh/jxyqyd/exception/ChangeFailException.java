package com.jhbh.jxyqyd.exception;

/**
 * 数据更改的异常  407
 * @Author:hou
 * @Date:2019/1/15
 */
public class ChangeFailException extends ServiceException {

    public ChangeFailException() {
    }

    public ChangeFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ChangeFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChangeFailException(String message) {
        super(message);
    }

    public ChangeFailException(Throwable cause) {
        super(cause);
    }
}
