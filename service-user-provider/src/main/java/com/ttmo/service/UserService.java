package com.ttmo.service;

import com.ttmo.core.response.Result;
import com.ttmo.domain.User;
import com.ttmo.validation.UserRegister;
import com.ttmo.validation.UsernameAlreadyExist;
import org.springframework.validation.annotation.Validated;

/**
 * @author yangqiaoxin
 * @date 2021/02/17
 */
public interface UserService {

    void verifyUsernameIfExists(@Validated({UsernameAlreadyExist.class}) User user);

    Result<Object> saveUser(@Validated({UserRegister.class}) User user);

}
