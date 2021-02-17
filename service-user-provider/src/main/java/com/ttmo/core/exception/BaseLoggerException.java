package com.ttmo.core.exception;

/**
 * 基础日志异常
 * @author yangqiaoxin
 * @date 2021/02/17
 */
public abstract class BaseLoggerException extends BaseException {
    public BaseLoggerException(String message) {
        super(message);
    }
}
