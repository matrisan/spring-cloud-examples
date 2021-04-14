package com.github.spring.cloud.user.center.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * TODO
 * <p>
 * create in 2021/4/13 10:28 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Getter
@Setter
@Validated
@Component
@ConfigurationProperties(prefix = "system.user.init")
public class PropertiesConfig {

    @NotBlank
    private String username;

    @NotBlank
    private String mobile;

    @NotBlank
    private String email;

}
