package com.github.spring.cloud.user.center.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * ObjectMapper 配置
 * <p>
 * create in 2021/4/24 3:31 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ObjectMapperConfig {

    private final ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

}
