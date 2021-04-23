package com.github.spring.cloud.user.center.infrastructure.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 配置 jsr303 参数校验快速失败
 * <p>
 * create in 2021/4/13 10:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
public class HibernateFailFastConfig {

    @Resource
    private LocalValidatorFactoryBean validator;

    private static final String FAIL_FAST = "hibernate.validator.fail_fast";

    /**
     * 配置 jsr303 参数校验快速失败
     */
    @PostConstruct
    public void init() {
        validator.getValidationPropertyMap().put(FAIL_FAST, "true");
        log.debug("参数校验快速失败设置:{}", FAIL_FAST);
    }


}
