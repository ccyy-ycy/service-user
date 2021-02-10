package com.ttmo.domain.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 资源枚举
 * @author yangqiaoxin
 * @date 2021/02/10
 */
public enum ResourceEnum {

    PERMISSION("permission", "权限管理"),
    ROLE("role", "角色管理"),
    USER("user", "用户管理");

    /**
     * 资源
     */
    @EnumValue
    private String resource;

    /**
     * 对资源的描述
     */
    private String description;

    ResourceEnum(String resource, String description) {
        this.resource = resource;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ResourceEnum{" +
                "resource='" + resource + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
