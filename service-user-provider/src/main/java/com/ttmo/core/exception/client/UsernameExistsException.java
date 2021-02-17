package com.ttmo.core.exception.client;

import com.ttmo.core.exception.BaseException;
import com.ttmo.core.response.Result;

/**
 * 用户名已存在
 * @author yangqiaoxin
 * @date 2021/02/16
 */
public class UsernameExistsException extends BaseException {

    @Override
    public <T> Result<T> responseInfo() {
        return Result.message("A0111", "用户名已存在", "用户名已存在");
    }

}
