package com.ttmo;

import cn.hutool.core.util.RandomUtil;
import com.ttmo.domain.User;
import com.ttmo.service.PermissionService;
import com.ttmo.service.RoleService;
import com.ttmo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

/**
 * @author yangqiaoxin
 * @date 2021/02/09
 */
@SpringBootTest
public class UserMainTest {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Test
    public void insertBatchUsers() {
        LinkedList<User> list = new LinkedList<>();
        User user;
        for (int i = 0, size = 100; i < size; i++) {
            user = new User();
            user.setUsername(RandomUtil.randomString("qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM", 10));
            user.setPassword(RandomUtil.randomString(16));
            user.setPhone("13" + RandomUtil.randomNumbers(9));
            user.setEmail(RandomUtil.randomString(12) + "@example.com");
            list.add(user);
        }
        userService.saveBatch(list, 100);
    }

}
