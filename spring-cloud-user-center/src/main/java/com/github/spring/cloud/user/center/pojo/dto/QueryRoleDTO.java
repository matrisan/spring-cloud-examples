package com.github.spring.cloud.user.center.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;

/**
 * TODO
 * <p>
 * create in 2021/4/14 9:59 下午
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
public class QueryRoleDTO {

    private String roleName;

    private String roleCode;

}