package com.ttmo.domain;

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
                    Login.class,
                    Register.class,
                    UsernameExist.class
            }
    )
    private String username;

    /**
     * 密码
     */
    @NotBlank(
            groups = {
                    Login.class,
                    Register.class
            }
    )
    @Length(
            min = 8,
            max = 16,
            groups = {
                    Login.class,
                    Register.class
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

    /**
     * 用户注册验证
     * @author yangqiaoxin
     * @date 2021/02/19
     */
    public interface Register {
    }

    /**
     * 登录验证
     * @author yangqiaoxin
     * @date 2021/02/19
     */
    public interface Login {
    }

    /**
     * 用户名已存在验证
     * @author yangqiaoxin
     * @date 2021/02/19
     */
    public interface UsernameExist {
    }

}
