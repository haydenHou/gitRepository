package com.qbwl.bkglpt02.exception;

/**
 * @author:Hayden
 * @Date:2019/7/18
 */
public class NoResultException extends ServiceException {


    public NoResultException() {
    }

    public NoResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NoResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoResultException(String message) {
        super(message);
    }

    public NoResultException(Throwable cause) {
        super(cause);
    }
}
