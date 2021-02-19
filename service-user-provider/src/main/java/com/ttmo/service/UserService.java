package com.ttmo.service;

import com.ttmo.core.response.Result;
import com.ttmo.domain.User;
import org.springframework.validation.annotation.Validated;

/**
 * @author yangqiaoxin
 * @date 2021/02/17
 */
public interface UserService {

    void verifyUsernameIfExists(@Validated({User.UsernameExist.class}) User user);

    Result<Object> saveUser(@Validated({User.Register.class}) User user);

}
