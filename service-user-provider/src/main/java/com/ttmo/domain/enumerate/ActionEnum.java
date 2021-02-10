package com.ttmo.domain.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 动作枚举
 * @author yangqiaoxin
 * @date 2021/02/10
 */
public enum ActionEnum {

    READ("4", "读取(r)"),
    WRITE("2", "写入(w)"),
    EXECUTE("1", "执行(x)");

    /**
     * 动作
     */
    @EnumValue
    private String action;

    /**
     * 对动作的描述
     */
    private String description;

    ActionEnum(String action, String description) {
        this.action = action;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ActionEnum{" +
                "action='" + action + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
