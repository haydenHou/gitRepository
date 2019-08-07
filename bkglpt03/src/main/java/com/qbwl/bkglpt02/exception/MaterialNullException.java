package com.qbwl.bkglpt02.exception;

/**
 *
 * @Author:hou
 * @Date:2019/1/8
 * 判定文件上传的异常
 */

public class MaterialNullException extends ServiceException {
    public MaterialNullException() {
    }

    public MaterialNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MaterialNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaterialNullException(String message) {
        super(message);
    }

    public MaterialNullException(Throwable cause) {
        super(cause);
    }
}
