package com.github.spring.cloud.user.center.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.spring.cloud.user.center.domain.common.ICreateView;
import com.github.spring.cloud.user.center.domain.common.IUpdateView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * TODO
 * <p>
 * create in 2021/4/14 7:27 下午
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
public class SystemRoleServiceDTO {

    @NotNull(groups = {IUpdateView.class})
    @JsonView({IUpdateView.class})
    private Long id;

    @NotBlank(groups = {ICreateView.class, IUpdateView.class})
    @JsonView({ICreateView.class, IUpdateView.class})
    private String roleName;

    @NotBlank(groups = {ICreateView.class, IUpdateView.class})
    @JsonView({ICreateView.class, IUpdateView.class})
    private String roleCode;



}
