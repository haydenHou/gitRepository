package com.jhbh.jxyqyd.exception;


/**
 * @Author:Hayden
 * @Date:2019/4/9
 */
public class PermissionDeniedException extends ServiceException {

    private int code;
    private String message;

    public PermissionDeniedException() {
    }

    public PermissionDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PermissionDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionDeniedException(String message) {
        super(message);
    }

    public PermissionDeniedException(Throwable cause) {
        super(cause);
    }

    public PermissionDeniedException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
