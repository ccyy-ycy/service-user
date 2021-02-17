package com.ttmo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttmo.core.exception.client.UsernameExistsException;
import com.ttmo.core.exception.third.DatabaseServiceException;
import com.ttmo.core.response.Result;
import com.ttmo.domain.User;
import com.ttmo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Pattern;

/**
 * @author yangqiaoxin
 * @date 2021/02/09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void verifyUsernameIfExists(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
        boolean isUsernameExists = count(wrapper) != 0;
        if (isUsernameExists) {
            throw new UsernameExistsException();
        }
    }

    @Override
    public Result<Object> saveUser(String username, String password) {
        // 封装数据
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        // 保存
        boolean hasSaved = save(user);
        if (hasSaved) {
            // 保存成功后自动登录
            /// ...............................
            return Result.ok("注册成功");
        }
        // 保存失败
        throw new DatabaseServiceException("注册失败, [username=" + username + ", password=" + password + "]");
    }

}
