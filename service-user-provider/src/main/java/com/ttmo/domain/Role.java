package com.ttmo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 角色
 *
 * @author yangqiaoxin
 * @date 2021/02/07
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends BaseEntity {

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 权限编号
     */
    private Long permissionId;

}
