package com.jhbh.jxyqyd.exception;

/**
 * 数据插入异常
 * @Author:hou
 * @Date:2018/12/24
 */
public class InsertDataException extends ServiceException {
    public InsertDataException() {
    }

    public InsertDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InsertDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertDataException(String message) {
        super(message);
    }

    public InsertDataException(Throwable cause) {
        super(cause);
    }
}
