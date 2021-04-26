package com.github.spring.cloud.statistics.application.service;

import com.github.javafaker.Faker;
import com.github.spring.cloud.statistics.interfaces.dto.MinuteActiveUserCommandDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * TODO
 * <p>
 * create in 2021/4/25 10:45 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@ActiveProfiles("junit")
@SpringBootTest
class IActiveUserMinuteServiceTest {

    private static final Faker FAKER1 = new Faker(Locale.CHINA);

    @Resource
    private IMinuteActiveUserService service;

    @Test
    void queryMau() {
    }

    @Rollback(value = false)
    @Test
    void save() {
        MinuteActiveUserCommandDTO command = getMinuteActiveUserCommand();
        service.save(command);
        log.info("保存数据:{}", command);
    }

    private MinuteActiveUserCommandDTO getMinuteActiveUserCommand() {
        return MinuteActiveUserCommandDTO.builder()
                .hostname(FAKER1.internet().domainName())
                .dateTime(LocalDateTime.now())
                .count(1000L)
                .build();
    }

}