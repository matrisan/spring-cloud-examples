package com.github.spring.cloud.user.center.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.spring.cloud.user.center.constraint.NewMobile;
import com.github.spring.cloud.user.center.constraint.NewOrUnchangedMobile;
import com.github.spring.cloud.user.center.constraint.NewUsername;
import com.github.spring.cloud.user.center.domain.common.ICreateView;
import com.github.spring.cloud.user.center.domain.common.IUpdateView;
import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.domain.manager.ISystemRoleManager;
import com.github.spring.cloud.user.center.domain.manager.ISystemUserManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * TODO
 * <p>
 * create in 2021/4/14 7:28 下午
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
@NewOrUnchangedMobile(groups = {IUpdateView.class})
public class SystemUserServiceDTO {

    @NotNull(groups = {IUpdateView.class})
    @JsonView({IUpdateView.class})
    private Long id;

    @NewUsername(groups = {ICreateView.class})
    @NotBlank(groups = {ICreateView.class, IUpdateView.class})
    @JsonView({ICreateView.class})
    private String username;

    @Pattern(regexp = "^[1][0-9]{10}$")
    @NewMobile(groups = {ICreateView.class})
    @NotBlank(groups = {ICreateView.class, IUpdateView.class})
    @JsonView({ICreateView.class, IUpdateView.class})
    private String mobile;

    @NotBlank(groups = {ICreateView.class, IUpdateView.class})
    @JsonView({ICreateView.class, IUpdateView.class})
    private String email;

    @Size(min = 1, groups = {ICreateView.class, IUpdateView.class})
    @JsonView({ICreateView.class, IUpdateView.class})
    private Set<Long> roleIds;

    public SystemUserDO saveNewSystemUser(ISystemUserManager userManager) {
        SystemUserDO user = SystemUserDO.builder()
                .username(username)
                .mobile(mobile)
                .email(email)
                .build();

//        return userManager.createSimpleUser(user);
        return null;
    }


    public SystemUserDO toSystemUser() {
        return SystemUserDO.builder()
                .id(id)
                .username(username)
                .mobile(mobile)
                .email(email)
                .build();
    }

    public SystemUserDO toNewSystemUser(ISystemRoleManager roleManager) {
        return SystemUserDO.builder()
                .username(username)
                .mobile(mobile)
                .email(email)
                .build();
    }

}
