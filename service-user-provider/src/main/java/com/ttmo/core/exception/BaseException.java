package com.ttmo.core.exception;

import com.ttmo.core.response.Result;

/**
 * 自定义异常的抽象基础
 * @author yangqiaoxin
 * @date 2021/02/16
 */
public abstract class BaseException extends RuntimeException {

    /**
     * 响应信息
     *
     * @return {@link Result<T>}
     * @author yangqiaoxin
     * @date 2021/02/17
     */
    public abstract <T> Result<T> responseInfo();

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
