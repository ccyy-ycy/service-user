package com.ttmo.mapper;

import com.ttmo.domain.User;

import java.util.List;

/**
 * 用户访问
 * @author yangqiaoxin
 * @date 2021/02/07
 */
public interface UserMapper {
    /*
        查看用户列表
        获取用户
        保存用户
        修改用户信息
        注销用户
     */
    List<User> listUsers();
}
