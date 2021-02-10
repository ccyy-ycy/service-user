package com.ttmo.domain.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
import lombok.ToString;

/**
 * 动作枚举
 * @author yangqiaoxin
 * @date 2021/02/10
 */
@Getter
@ToString
public enum ActionEnum {

    /**
     * 默认值(该值无法保存到数据库中)
     */
    NONE(null, "没有权限"),
    READ("4", "读取"),
    WRITE("2", "写入"),
    EXECUTE("1", "执行");

    /**
     * 动作
     */
    @EnumValue
    private final String action;

    /**
     * 对动作的描述
     */
    private final String description;

    ActionEnum(String action, String description) {
        this.action = action;
        this.description = description;
    }

}
