package com.github.spring.cloud.statistics.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * TODO
 * <p>
 * create in 2021/4/25 10:04 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MinuteActiveUserCommandDTO {

    private LocalDateTime dateTime;

    private String hostname;

    private Long count;

}
