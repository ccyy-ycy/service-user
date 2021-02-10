package com.ttmo.domain.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
import lombok.ToString;

/**
 * 资源枚举
 * @author yangqiaoxin
 * @date 2021/02/10
 */
@Getter
@ToString
public enum ResourceEnum {

    /**
     * 默认值(该值无法保存到数据库中)
     */
    NONE(null, "没有资源"),
    PERMISSION("permission", "权限管理"),
    ROLE("role", "角色管理"),
    USER("user", "用户管理");

    /**
     * 资源
     */
    @EnumValue
    private final String resource;

    /**
     * 对资源的描述
     */
    private final String description;

    ResourceEnum(String resource, String description) {
        this.resource = resource;
        this.description = description;
    }

}
