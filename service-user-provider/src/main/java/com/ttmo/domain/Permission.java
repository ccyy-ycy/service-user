package com.ttmo.domain;

import com.ttmo.domain.enumerate.ActionEnum;
import com.ttmo.domain.enumerate.ResourceEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 权限
 * @author yangqiaoxin
 * @date 2021/02/07
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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
