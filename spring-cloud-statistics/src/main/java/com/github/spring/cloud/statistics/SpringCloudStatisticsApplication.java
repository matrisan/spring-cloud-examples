package com.github.spring.cloud.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringCloudStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStatisticsApplication.class, args);
    }

}
