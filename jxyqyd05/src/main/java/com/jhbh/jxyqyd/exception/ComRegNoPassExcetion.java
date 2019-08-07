package com.jhbh.jxyqyd.exception;

/**
 * @author:Hayden
 * @Date:2019/7/11
 */
public class ComRegNoPassExcetion extends ServiceException{

    public ComRegNoPassExcetion() {
    }

    public ComRegNoPassExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ComRegNoPassExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public ComRegNoPassExcetion(String message) {
        super(message);
    }

    public ComRegNoPassExcetion(Throwable cause) {
        super(cause);
    }
}
