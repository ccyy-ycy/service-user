package com.ttmo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttmo.core.exception.client.UsernameExistsException;
import com.ttmo.core.exception.third.DatabaseServiceException;
import com.ttmo.core.response.Result;
import com.ttmo.domain.User;
import com.ttmo.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author yangqiaoxin
 * @date 2021/02/09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void verifyUsernameIfExists(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", user.getUsername());
        boolean isUsernameExists = count(wrapper) != 0;
        if (isUsernameExists) {
            throw new UsernameExistsException();
        }
    }

    @Override
    public Result<Object> saveUser(User user) {
        // 封装所需的数据
        User wrapper = new User();
        wrapper.setUsername(user.getUsername());
        wrapper.setPassword(user.getPassword());
        // 保存
        boolean hasSaved = save(wrapper);
        if (hasSaved) {
            // 保存成功后自动登录
            /// ...............................
            return Result.ok("注册成功");
        }
        // 保存失败
        throw new DatabaseServiceException("注册失败, " + wrapper);
    }

}
