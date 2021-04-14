package com.github.spring.cloud.user.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shishaodong
 */
@EnableCaching
@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
public class SpringCloudUserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserCenterApplication.class, args);
    }

}
