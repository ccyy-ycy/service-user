package com.ttmo.domain;

import lombok.Data;

/**
 * 用户
 * @author yangqiaoxin
 * @date 2021/02/07
 */
@Data
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

}
