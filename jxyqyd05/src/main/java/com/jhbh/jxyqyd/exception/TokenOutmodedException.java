package com.jhbh.jxyqyd.exception;

/**
 * @author:Hayden
 * @Date:2019/5/16
 */
public class TokenOutmodedException extends ServiceException{

    public TokenOutmodedException() {
    }

    public TokenOutmodedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TokenOutmodedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenOutmodedException(String message) {
        super(message);
    }

    public TokenOutmodedException(Throwable cause) {
        super(cause);
    }
}
