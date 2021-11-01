package com.itheima.exception.bu;

/**
 * 业务异常包装
 */
public class BusinessException extends RuntimeException{

    public BusinessException() {
    }


    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
