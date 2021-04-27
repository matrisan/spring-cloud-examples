package com.github.spring.cloud.user.center.domain.manager;

import com.github.javafaker.Faker;
import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.infrastructure.config.SystemInitUserConfig;
import com.github.spring.cloud.user.center.interfaces.dto.UserCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserUpdateCommandDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * TODO
 * <p>
 * create in 2021/4/24 10:53 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Rollback
@SpringBootTest
@ActiveProfiles("junit")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ISystemUserManagerTest {

    @Resource
    private ISystemUserManager userManager;

    @Resource
    private SystemInitUserConfig userConfig;

    @Resource
    private PasswordEncoder encoder;

    @DisplayName("判断用户名是否存在")
    @Order(1)
    @Test
    void existsByUsername() {
        boolean root = userManager.existsByUsername(userConfig.getUsername());
        Assertions.assertTrue(root);
    }

    @DisplayName("判断手机号码是否存在")
    @Order(2)
    @Test
    void existsByMobile() {
        boolean root = userManager.existsByMobile(userConfig.getMobile());
        Assertions.assertTrue(root);
    }

    @DisplayName("获取当前用户的密码用户")
    @WithUserDetails(value = "root", userDetailsServiceBeanName = "systemUserServiceImpl")
    @Order(3)
    @Test
    void findCurrentPassword() {
        String password = userManager.findCurrentPassword();
        Assertions.assertTrue(encoder.matches(userConfig.getPassword(), password));
    }

    @DisplayName("根据 ID 查询用户")
    @Order(4)
    @Test
    void findSimpleUserById() {
        UserCreateCommandDTO command = getUserCreateCommand();
        log.info("创建的数据:{}", command);
        UserSaveResultDTO result = userManager.createSimpleUser(command);
        log.info("保存完数据:{}", result);
        SystemUserDO user = userManager.findSimpleUserById(result.getId());
        Assertions.assertEquals(user.getId(), result.getId());
    }

    @DisplayName("根据用户名查询用户信息")
    @Order(5)
    @Test
    void findSimpleUserByUsername() {
        SystemUserDO user = userManager.findSimpleUserByUsername(userConfig.getUsername());
        log.info("查询的数据:{}", user);
        Assertions.assertEquals(user.getUsername(), userConfig.getUsername());
    }

    @DisplayName("根据手机号查询用户信息")
    @Order(6)
    @Test
    void findSimpleUserByMobile() {
        SystemUserDO user = userManager.findSimpleUserByMobile(userConfig.getMobile());
        log.info("查询的数据:{}", user);
        Assertions.assertEquals(user.getMobile(), userConfig.getMobile());
    }

    @DisplayName("创建用户信息")
    @Order(7)
    @Test
    void createSimpleUser() {
        UserCreateCommandDTO command = getUserCreateCommand();
        log.info("创建的数据:{}", command);
        UserSaveResultDTO result = userManager.createSimpleUser(command);
        Assertions.assertEquals(command.getUsername(), result.getUsername());
    }

    @DisplayName("更新用户信息")
    @Order(8)
    @Rollback
    @Test
    void updateSimpleUser() {
        UserUpdateCommandDTO command = getUpdateCreateCommand();
        log.info("更新的数据:{}", command);
        UserSaveResultDTO result = userManager.updateSimpleUser(command);
        Assertions.assertEquals(command.getUsername(), result.getUsername());
    }

    @DisplayName("删除用户测试")
    @Order(9)
    @Test
    void deleteSimpleUser() {
        SystemUserDO simpleUserByUsername = userManager.findSimpleUserByUsername(userConfig.getUsername());
        log.info("要删除的的数据:{}", simpleUserByUsername);
        userManager.deleteSimpleUser(simpleUserByUsername);
        Assertions.assertFalse(userManager.existsByUsername(userConfig.getUsername()));
    }

    private static final Faker FAKER1 = new Faker(Locale.CHINA);

    private static final Faker FAKER2 = new Faker(Locale.CHINESE);

    private UserCreateCommandDTO getUserCreateCommand() {
        UserCreateCommandDTO command = new UserCreateCommandDTO();
        command.setUsername("test_" + FAKER2.name().username());
        command.setMobile(FAKER1.phoneNumber().cellPhone());
        command.setPassword("123456");
        command.setEmail(FAKER1.internet().emailAddress());
        return command;
    }

    private UserUpdateCommandDTO getUpdateCreateCommand() {
        UserUpdateCommandDTO command = new UserUpdateCommandDTO();
        command.setId(1L);
        command.setUsername("test_" + FAKER2.name().username());
        command.setMobile(FAKER1.phoneNumber().cellPhone());
        command.setPassword("123456");
        command.setEmail(FAKER1.internet().emailAddress());
        return command;
    }

}