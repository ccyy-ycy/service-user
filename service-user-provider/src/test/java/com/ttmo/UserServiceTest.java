package com.ttmo;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ttmo.domain.Permission;
import com.ttmo.domain.Role;
import com.ttmo.domain.User;
import com.ttmo.domain.enumerate.ActionEnum;
import com.ttmo.domain.enumerate.ResourceEnum;
import com.ttmo.service.PermissionService;
import com.ttmo.service.RoleService;
import com.ttmo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author yangqiaoxin
 * @date 2021/02/09
 */
@SpringBootTest(classes = UserMain.class)
public class UserServiceTest {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Test
    public void batchInsertPermissionTest() {

        EnumSet<ActionEnum> actionEnums = EnumSet.allOf(ActionEnum.class);
        actionEnums.remove(ActionEnum.NONE);
        EnumSet<ResourceEnum> resourceEnums = EnumSet.allOf(ResourceEnum.class);
        resourceEnums.remove(ResourceEnum.NONE);

        List<Permission> permissions = new ArrayList<>(16);
        Permission permission;
        for (ActionEnum actionEnum : actionEnums) {
            for (ResourceEnum resourceEnum : resourceEnums) {
                permission = new Permission();
                permission.setName(actionEnum.getDescription() + resourceEnum.getDescription());
                permission.setResource(resourceEnum);
                permission.setAction(actionEnum);
                permissions.add(permission);
            }
        }

        boolean hasData = !permissions.isEmpty();
        if (hasData) {
            permissionService.saveBatch(permissions, 100);
        }
    }

    @Test
    public void batchInsertUserTest() {
        List<User> users = new ArrayList<>(100);

        User user;
        for (int i = 0, size = 100; i < size; ) {
            user = new User();
            user.setUsername(RandomUtil.randomString("qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM", 8));
            user.setPassword(RandomUtil.randomString(16));
            user.setPhone("13" + RandomUtil.randomNumbers(9));
            user.setEmail(RandomUtil.randomString(7) + "@example.com");

            boolean isValid = !users.contains(user);
            if (isValid) {
                users.add(user);
                i++;
            }
        }

        userService.saveBatch(users, 100);
    }

    @Test
    public void batchInsertRoleTest() {
        List<Role> roles = new ArrayList<>(100);

        Role role;
        for (int i = 0, size = 100; i < size; ) {
            role = new Role();
            role.setUserId(RandomUtil.randomLong(1, 101));
            role.setPermissionId(RandomUtil.randomLong(1, 10));

            boolean isValid = !roles.contains(role);
            if (isValid) {
                roles.add(role);
                i++;
            }
        }

        roleService.saveBatch(roles, 100);
    }

    @Test
    public void getUserByUsernameTest() {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", "HVpzjWLw"));
        System.out.println(user);
        user = userService.getOne(new QueryWrapper<User>().eq("username", "admin"));
        System.out.println(user);
    }

    @Test
    public void getRoleTest() {
        Role role = roleService.getOne(new QueryWrapper<Role>()
                .eq("user_id", 99)
                .eq("permission_id", 6)
        );
        System.out.println(role);
        role = roleService.getOne(new QueryWrapper<Role>()
                .eq("user_id", 100)
                .eq("permission_id", 7)
        );
        System.out.println(role);
    }

    @Test
    public void updateUserPassword() {
        boolean hasUpdated = userService.update(new UpdateWrapper<User>()
                .eq("id", 34)
                .eq("password", "lqhrl1pvhdxuqaut")
                .set("password", "123456")
        );
        System.out.println(hasUpdated);
        hasUpdated = userService.update(new UpdateWrapper<User>()
                .eq("id", 35)
                .eq("password", "lqhrl1pvhdxuqaut")
                .set("password", "666666")
        );
        System.out.println(hasUpdated);
    }

    @Test
    public void batchLogicDeletePermissionTest() {
        List<Long> list = LongStream.range(1L, 10L).boxed().collect(Collectors.toList());
        boolean isSuccessRemove = permissionService.removeByIds(list);
        if (isSuccessRemove) {
            System.out.println("删除成功");
        }
    }

}
