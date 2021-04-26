package com.github.spring.cloud.statistics.interfaces.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * TODO
 * <p>
 * create in 2021/4/25 5:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@JsonDeserialize(as = IMinuteActiveUserDTO.MinuteActiveUserDTO.class)
public interface IMinuteActiveUserDTO {

    LocalDateTime getDateTime();

    String getHostname();

    Long getCount();

    @Slf4j
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    class MinuteActiveUserDTO {

        private LocalDateTime dateTime;

        private String hostname;

        private Long count;

    }


}
