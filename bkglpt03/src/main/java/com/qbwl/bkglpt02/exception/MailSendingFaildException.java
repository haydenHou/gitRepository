package com.qbwl.bkglpt02.exception;

/**
 * @Author:Hayden
 * @Date:2019/3/1
 * 邮件发送异常
 */
public class MailSendingFaildException extends ServiceException{

    public MailSendingFaildException() {
    }

    public MailSendingFaildException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MailSendingFaildException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailSendingFaildException(String message) {
        super(message);
    }

    public MailSendingFaildException(Throwable cause) {
        super(cause);
    }
}
