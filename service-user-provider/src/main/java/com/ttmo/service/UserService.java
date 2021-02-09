package com.ttmo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttmo.domain.User;
import com.ttmo.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author yangqiaoxin
 * @date 2021/02/09
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
}
