package com.jhbh.jxyqyd.exception;

/**
 * @author:Hayden
 * @Date:2019/7/11
 */
public class ComExitException extends ServiceException{
    public ComExitException() {
    }

    public ComExitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ComExitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComExitException(String message) {
        super(message);
    }

    public ComExitException(Throwable cause) {
        super(cause);
    }
}
