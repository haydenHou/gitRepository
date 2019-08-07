package com.qbwl.bkglpt02.exception;

/**
 * 数据插入异常
 * @Author:hou
 * @Date:2018/12/24
 */
public class InsertFailException extends ServiceException {
    public InsertFailException() {
    }

    public InsertFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InsertFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertFailException(String message) {
        super(message);
    }

    public InsertFailException(Throwable cause) {
        super(cause);
    }
}
