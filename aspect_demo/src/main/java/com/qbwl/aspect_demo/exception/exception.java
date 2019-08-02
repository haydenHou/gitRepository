package com.qbwl.aspect_demo.exception;

/**
 * @author:Hayden
 * @Date:2019/8/1
 */
public class exception extends RuntimeException {

    public exception() {
    }

    public exception(String message) {
        super(message);
    }

    public exception(String message, Throwable cause) {
        super(message, cause);
    }

    public exception(Throwable cause) {
        super(cause);
    }

    public exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
