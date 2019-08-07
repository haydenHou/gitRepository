package com.qbwl.bkglpt02.exception;

/**
 * 数据格式异常
 * @author:Hayden
 * @Date:2019/4/27
 */
public class DataFormatException extends ServiceException {

    public DataFormatException() {
    }

    public DataFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(Throwable cause) {
        super(cause);
    }
}
