package com.qbwl.bkglpt02.exception;

/**
 * @Author:hou
 * @Date:2019/1/15
 * 数据更改的异常  407
 */
public class UpdateFailException extends ServiceException {

    public UpdateFailException() {
    }

    public UpdateFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UpdateFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateFailException(String message) {
        super(message);
    }

    public UpdateFailException(Throwable cause) {
        super(cause);
    }
}
