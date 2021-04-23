package com.github.spring.cloud.user.center.application.service;

import com.github.spring.cloud.user.center.domain.entity.SystemRoleDO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleQueryDTO;
import com.github.spring.cloud.user.center.interfaces.dto.SystemRoleServiceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO
 * <p>
 * create in 2021/4/14 7:26 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemRoleService {

    Page<SystemRoleDO> findAllRoles(RoleQueryDTO queryRole, Pageable pageable);

    SystemRoleDO createRole(SystemRoleServiceDTO createRole);

    SystemRoleDO updateRole(SystemRoleServiceDTO createRole);

    int deleteRoleById(SystemRoleDO role);

}
