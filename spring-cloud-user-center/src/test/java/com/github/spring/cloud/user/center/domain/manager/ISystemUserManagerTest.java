package com.github.spring.cloud.user.center.domain.manager;

import com.github.spring.cloud.user.center.infrastructure.config.SystemInitUserConfig;
import com.github.spring.cloud.user.center.interfaces.dto.UserCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserUpdateCommandDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/4/24 10:53 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Rollback(value = false)
@SpringBootTest
class ISystemUserManagerTest {

    @Resource
    private ISystemUserManager userManager;

    @Resource
    private SystemInitUserConfig userConfig;

    @Resource
    private PasswordEncoder encoder;

    @Test
    void existsByUsername() {
        boolean root = userManager.existsByUsername(userConfig.getUsername());
        Assertions.assertTrue(root);
    }

    @Test
    void existsByMobile() {
        boolean root = userManager.existsByMobile(userConfig.getMobile());
        Assertions.assertTrue(root);
    }

    //    @WithUserDetails(value = "${system.user.init.username}", userDetailsServiceBeanName = "systemUserServiceImpl")
//    @WithMockUser(username = "${system.user.init.username}")
    @Disabled
    @Test
    void findCurrentPassword() {
        String password = userManager.findCurrentPassword();
        Assertions.assertTrue(encoder.matches(userConfig.getPassword(), password));
    }

    @Test
    void findSimpleUserById() {


    }

    @Test
    void findSimpleUserByUsername() {
    }

    @Test
    void findSimpleUserByMobile() {
    }

    @Test
    void createSimpleUser() {
        UserCreateCommandDTO command = getUserCreateCommand();
        UserSaveResultDTO result = userManager.createSimpleUser(command);
        Assertions.assertEquals(command.getUsername(), result.getUsername());
    }

    @DisplayName("更新用户信息")
    @Rollback
    @Test
    void updateSimpleUser() {
        UserUpdateCommandDTO command = getUpdateCreateCommand();
        UserSaveResultDTO result = userManager.updateSimpleUser(command);
        Assertions.assertEquals(command.getUsername(), result.getUsername());
    }

    @Test
    void deleteSimpleUser() {
    }

    private UserCreateCommandDTO getUserCreateCommand() {
        UserCreateCommandDTO command = new UserCreateCommandDTO();
        command.setUsername("test_username01");
        command.setMobile("18888888888");
        command.setPassword("123456");
        command.setEmail("test_email@mail.com");
        return command;
    }

    private UserUpdateCommandDTO getUpdateCreateCommand() {
        UserUpdateCommandDTO command = new UserUpdateCommandDTO();
        command.setId(1L);
        command.setUsername("test_root");
        command.setMobile("19999999999");
        command.setPassword("123456");
        command.setEmail("test_email2@mail.com");
        return command;
    }


}