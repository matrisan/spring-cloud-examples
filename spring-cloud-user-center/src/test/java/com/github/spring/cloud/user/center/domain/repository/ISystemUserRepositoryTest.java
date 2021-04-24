package com.github.spring.cloud.user.center.domain.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/4/24 3:17 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ISystemUserRepositoryTest {

    @Resource
    private ISystemUserRepository repository;

    @Test
    void existsByUsername() {
        boolean root = repository.existsByUsername("root");
        Assertions.assertTrue(root);
    }

    @Test
    void existsByMobile() {
    }

    @Test
    void findAllBy() {
    }

    @Test
    void findCurrentPassword() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByUsernameEquals() {
    }

    @Test
    void findByMobileEquals() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void updateCurrentPassword() {
    }

    @Test
    void updateLastLoginDate() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}