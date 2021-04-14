package com.github.spring.cloud.open.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shishaodong
 */
@EnableFeignClients
@SpringBootApplication
public class SpringCloudOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOpenFeignApplication.class, args);
    }

}
