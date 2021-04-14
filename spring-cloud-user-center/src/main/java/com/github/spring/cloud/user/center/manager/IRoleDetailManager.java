package com.github.spring.cloud.user.center.manager;

import com.github.spring.cloud.user.center.pojo.entity.SystemRoleDO;

/**
 * TODO
 * <p>
 * create in 2021/4/14 11:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IRoleDetailManager {

    SystemRoleDO findById(long id);

    SystemRoleDO findByRoleCode(String roleCode);

    boolean existsByRoleCode(String roleCode);

    SystemRoleDO save(SystemRoleDO systemRole);

    SystemRoleDO updateRole(SystemRoleDO systemRole);

    void deleteRole(SystemRoleDO systemRole);

}
