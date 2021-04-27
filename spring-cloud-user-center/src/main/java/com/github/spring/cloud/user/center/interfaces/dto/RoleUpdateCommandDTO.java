package com.github.spring.cloud.user.center.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * TODO
 * <p>
 * create in 2021/4/23 6:13 下午
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
public class RoleUpdateCommandDTO {

    private Long id;

    private String roleName;

    private String roleCode;

    private Set<Long> menuIds;
}
