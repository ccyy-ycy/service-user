package com.ttmo.domain;

import lombok.Data;

/**
 * 角色
 * @author yangqiaoxin
 * @date 2021/02/07
 */
@Data
public class Role extends BaseEntity {

    /**
     * 角色名称
     */
    private String name;

}