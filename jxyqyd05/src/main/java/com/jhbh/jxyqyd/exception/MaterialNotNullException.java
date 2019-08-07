package com.jhbh.jxyqyd.exception;

/**
 * 判定文件上传的异常
 * @Author:hou
 * @Date:2019/1/8
 */

public class MaterialNotNullException extends ServiceException {
    public MaterialNotNullException() {
    }

    public MaterialNotNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MaterialNotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaterialNotNullException(String message) {
        super(message);
    }

    public MaterialNotNullException(Throwable cause) {
        super(cause);
    }
}
