package com.ttmo.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 响应对象
 *
 * @author yangqiaoxin
 * @date 2021/02/16
 */
@Data
@AllArgsConstructor
public class Result<T> {

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 用户提示信息
     */
    private String userTip;

    public static <T> Result<T> ok(String userTip) {
        return message("00000", "一切ok", userTip);
    }

    public static <T> Result<T> systemExecuteError(String userTip) {
        return message("B0001", "系统执行出错", userTip);
    }

    public static <T> Result<T> message(String code, String message, String userTip) {
        return message(code, message, null, userTip);
    }

    public static <T> Result<T> message(String code, String message, T data, String userTip) {
        return new Result<>(code, message, data, userTip);
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

    public Result<T> userTip(String userTip) {
        this.userTip = userTip;
        return this;
    }

}
