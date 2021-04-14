package com.github.spring.cloud.user.center.service;

import com.github.spring.cloud.user.center.pojo.dto.QueryRoleDTO;
import com.github.spring.cloud.user.center.pojo.dto.SystemRoleServiceDTO;
import com.github.spring.cloud.user.center.pojo.entity.SystemRoleDO;
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

    Page<SystemRoleDO> findAllRoles(QueryRoleDTO queryRole, Pageable pageable);

    SystemRoleDO createRole(SystemRoleServiceDTO createRole);

    SystemRoleDO updateRole(SystemRoleServiceDTO createRole);

    int deleteRoleById(SystemRoleDO role);

}
