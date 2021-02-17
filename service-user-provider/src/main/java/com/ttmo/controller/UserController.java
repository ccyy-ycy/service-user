package com.ttmo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ttmo.core.exception.third.DatabaseServiceException;
import com.ttmo.core.response.Result;
import com.ttmo.domain.User;
import com.ttmo.core.exception.client.UsernameExistsException;
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
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
        boolean isUsernameExists = userService.count(wrapper) != 0;
        if (isUsernameExists) {
            throw new UsernameExistsException();
        }

        // 保存账户信息到数据库中
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean hasSaved = userService.save(user);
        if (hasSaved) {
            // 登录逻辑
            /// ...............................
            return Result.ok("注册成功");
        }
        // 保存失败
        throw new DatabaseServiceException("注册失败, [username=" + username + ", password=" + password + "]");
    }

}
