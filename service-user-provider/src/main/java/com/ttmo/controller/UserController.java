package com.ttmo.controller;

import com.ttmo.core.response.Result;
import com.ttmo.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
    public Result<Object> register(
            @Pattern(regexp = "^[a-zA-Z]{6,12}$") String username,
            @NotBlank @Length(min = 8, max = 16) String password
    ) {
        // 检测用户名是否已被使用
        userService.verifyUsernameIfExists(username);

        // 保存账户信息到数据库中
        return userService.saveUser(username, password);
    }

}
