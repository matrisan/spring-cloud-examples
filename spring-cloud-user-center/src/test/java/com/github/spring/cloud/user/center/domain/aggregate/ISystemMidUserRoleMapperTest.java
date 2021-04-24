package com.github.spring.cloud.user.center.domain.aggregate;

import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 * <p>
 * create in 2021/4/24 10:04 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class ISystemMidUserRoleMapperTest {

    @Test
    void from() {
    }

    private SystemUserDO getUser() {
        SystemUserDO userDO = new SystemUserDO();
        userDO.setId(1L);
        return userDO;
    }
}