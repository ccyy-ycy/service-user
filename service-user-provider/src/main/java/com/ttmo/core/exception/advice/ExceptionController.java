package com.ttmo.core.exception.advice;

import com.ttmo.core.exception.BaseLoggerException;
import com.ttmo.core.response.Result;
import com.ttmo.core.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 * @author yangqiaoxin
 * @date 2021/02/16
 */
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    /**
     * 异常处理
     * 如果是自定义异常，则返回该异常的错误信息
     * 否则默认返回系统执行出错的错误信息
     *
     * @param e 异常
     * @param response HTTP响应
     * @return {@link Result}
     * @author yangqiaoxin
     * @date 2021/02/17
     */
    @ExceptionHandler
    public Result<Object> handler(Throwable e, HttpServletResponse response) {
        response.setStatus(500);
        // 如果是自定义异常，则返回该异常的错误信息
        if (e instanceof BaseException) {
            BaseException base = (BaseException) e;
            // 如果是日志异常，则将错误消息输出到日志中
            if (base instanceof BaseLoggerException) {
                BaseLoggerException baseMessage = (BaseLoggerException) base;
                log.error(baseMessage.getMessage());
            }
            return base.responseInfo();
        }
        // 否则默认返回系统执行出错
        return Result.systemExecuteError("操作失败");
    }

}
