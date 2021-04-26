package com.github.spring.cloud.statistics.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * TODO
 * <p>
 * create in 2021/4/25 5:43 下午
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
public class QueryMinuteActiveUserDTO {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Set<String> hostname;


}
