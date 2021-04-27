package com.github.spring.cloud.user.center.domain.manager;

import com.github.spring.cloud.user.center.domain.entity.SystemRoleDO;
import com.github.spring.cloud.user.center.interfaces.dto.IRoleQueryResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.IRoleSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleQueryDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleUpdateCommandDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * 角色管理类
 * <p>
 * create in 2021/4/17 9:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemRoleManager {

    Page<IRoleQueryResultDTO> findAllRoles(RoleQueryDTO queryRole, Pageable pageable);

    Optional<IRoleQueryResultDTO> findById(long id);

    IRoleSaveResultDTO createRole(RoleCreateCommandDTO createRole);

    IRoleSaveResultDTO updateRole(RoleUpdateCommandDTO createRole);

    int deleteRoleById(SystemRoleDO role);

}
