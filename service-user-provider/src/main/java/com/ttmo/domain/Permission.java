package com.ttmo.domain;

import com.ttmo.domain.enumerate.ActionEnum;
import com.ttmo.domain.enumerate.ResourceEnum;
import lombok.Data;

/**
 * 权限
 * @author yangqiaoxin
 * @date 2021/02/07
 */
@Data
public class Permission extends BaseEntity {

    /**
     * 权限名称
     */
    private String name;

    /**
     * 资源
     */
    private ResourceEnum resource;

    /**
     * 动作
     */
    private ActionEnum action;

}
