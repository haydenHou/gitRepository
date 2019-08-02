package com.qbwl.aspect_demo.exception;

/**
 * @Author:hou
 * @Date:2018/12/20
 */

/**
 *
 */
public class UsernameConflictException extends ServiceException {

    public UsernameConflictException() {
    }

    public UsernameConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UsernameConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameConflictException(String message) {
        super(message);
    }

    public UsernameConflictException(Throwable cause) {
        super(cause);
    }
}
