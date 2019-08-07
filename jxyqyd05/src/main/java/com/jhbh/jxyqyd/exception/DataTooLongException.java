package com.jhbh.jxyqyd.exception;

/**
 * 数据格式异常
 * @author:Hayden
 * @Date:2019/4/27
 */
public class DataTooLongException extends ServiceException {

    public DataTooLongException() {
    }

    public DataTooLongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DataTooLongException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataTooLongException(String message) {
        super(message);
    }

    public DataTooLongException(Throwable cause) {
        super(cause);
    }
}
