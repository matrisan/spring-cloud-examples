package com.github.spring.cloud.user.center.domain.manager;

import com.github.spring.cloud.user.center.interfaces.dto.IRoleQueryResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleUpdateCommandDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/4/26 7:28 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Rollback
@SpringBootTest
@ActiveProfiles("junit")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ISystemRoleManagerTest {

    @Resource
    private ISystemRoleManager roleManager;

    @Test
    void findAllRoles() {

    }

    @Test
    void findById() {
        Optional<IRoleQueryResultDTO> manager = roleManager.findById(1L);
        manager.ifPresent(iRoleQueryResultDTO -> Assertions.assertEquals(iRoleQueryResultDTO.getRoleCode(), "ROLE_ROOT"));
    }

    @Test
    void createRole() {


    }

    @Test
    void updateRole() {
    }

    @Test
    void deleteRoleById() {
    }

    private RoleCreateCommandDTO getRoleCreateCommand() {
        return RoleCreateCommandDTO.builder().roleName("test_root").roleCode("ROLE_TEST01").build();
    }


    private RoleUpdateCommandDTO getRoleUpdateCommand() {
        return RoleUpdateCommandDTO.builder().id(1L).roleName("test_root").roleCode("ROLE_TEST01").build();

    }


}