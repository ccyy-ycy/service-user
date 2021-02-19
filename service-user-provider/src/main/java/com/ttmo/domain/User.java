package com.ttmo.domain;

import com.ttmo.validation.UserLogin;
import com.ttmo.validation.UserRegister;
import com.ttmo.validation.UsernameAlreadyExist;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 用户
 *
 * @author yangqiaoxin
 * @date 2021/02/07
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {

    /**
     * 用户名
     */
    @Pattern(
            regexp = "^[a-zA-Z]{6,12}$",
            groups = {
                    UserLogin.class,
                    UserRegister.class,
                    UsernameAlreadyExist.class
            }
    )
    private String username;

    /**
     * 密码
     */
    @NotBlank(
            groups = {
                    UserLogin.class,
                    UserRegister.class
            }
    )
    @Length(
            min = 8,
            max = 16,
            groups = {
                    UserLogin.class,
                    UserRegister.class
            }
    )
    private String password;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

}
