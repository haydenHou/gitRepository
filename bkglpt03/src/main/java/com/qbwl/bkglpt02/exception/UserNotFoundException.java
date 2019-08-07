package com.qbwl.bkglpt02.exception;

/**
 * @Author:hou
 * @Date:2018/12/20
 */

/**
 * 不存在改用户
 */
public class UserNotFoundException extends ServiceException{
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
