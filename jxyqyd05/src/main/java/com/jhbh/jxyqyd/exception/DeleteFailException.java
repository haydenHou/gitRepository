package com.jhbh.jxyqyd.exception;

/**
 * 删除失败异常
 * @Author:hou
 * @Date:2019/1/9
 */
public class DeleteFailException extends ServiceException {

    public DeleteFailException() {
    }

    public DeleteFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DeleteFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteFailException(String message) {
        super(message);
    }

    public DeleteFailException(Throwable cause) {
        super(cause);
    }
}
