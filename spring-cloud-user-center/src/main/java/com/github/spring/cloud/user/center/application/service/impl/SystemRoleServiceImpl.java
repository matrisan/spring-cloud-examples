package com.github.spring.cloud.user.center.application.service.impl;

import com.github.spring.cloud.user.center.application.service.ISystemRoleService;
import com.github.spring.cloud.user.center.domain.entity.SystemRoleDO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleQueryDTO;
import com.github.spring.cloud.user.center.interfaces.dto.SystemRoleServiceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO
 * <p>
 * create in 2021/4/17 4:26 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class SystemRoleServiceImpl implements ISystemRoleService {

    @Override
    public Page<SystemRoleDO> findAllRoles(RoleQueryDTO queryRole, Pageable pageable) {
        return null;
    }

    @Override
    public SystemRoleDO createRole(SystemRoleServiceDTO createRole) {
        return null;
    }

    @Override
    public SystemRoleDO updateRole(SystemRoleServiceDTO createRole) {
        return null;
    }

    @Override
    public int deleteRoleById(SystemRoleDO role) {
        return 0;
    }
}
