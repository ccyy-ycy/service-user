package com.ttmo.service;

import com.ttmo.core.response.Result;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author yangqiaoxin
 * @date 2021/02/17
 */
public interface UserService {

    void verifyUsernameIfExists(@Pattern(regexp = "^[a-zA-Z]{6,12}$") String username);

    Result<Object> saveUser(@Pattern(regexp = "^[a-zA-Z]{6,12}$") String username,
                            @NotBlank @Length(min = 8, max = 16) String password);

}
