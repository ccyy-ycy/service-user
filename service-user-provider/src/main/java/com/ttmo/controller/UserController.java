package com.ttmo.controller;

import com.ttmo.core.response.Result;
import com.ttmo.domain.User;
import com.ttmo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 HTTP 访问接口
 *
 * @author yangqiaoxin
 * @date 2021/02/16
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<Object> register(@Validated({User.Register.class}) User user) {
        // 检测用户名是否已被使用
        userService.verifyUsernameIfExists(user);

        // 保存账户信息到数据库中
        return userService.saveUser(user);
    }

}
