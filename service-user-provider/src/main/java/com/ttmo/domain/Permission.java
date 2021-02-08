package com.ttmo.domain;

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
     * 动作
     */
    private String action;
}
