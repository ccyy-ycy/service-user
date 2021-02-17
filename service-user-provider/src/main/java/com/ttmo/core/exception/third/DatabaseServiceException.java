package com.ttmo.core.exception.third;

import com.ttmo.core.exception.BaseLoggerException;
import com.ttmo.core.response.Result;

/**
 * 数据库服务出错
 * @author yangqiaoxin
 * @date 2021/02/17
 */
public class DatabaseServiceException extends BaseLoggerException {

    public DatabaseServiceException(String message) {
        super(message);
    }

    @Override
    public <T> Result<T> responseInfo() {
        return Result.message("C0300", "数据库服务出错", "操作失败，请重试");
    }

}
