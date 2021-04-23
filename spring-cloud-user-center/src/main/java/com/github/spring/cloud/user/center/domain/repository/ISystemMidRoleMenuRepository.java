package com.github.spring.cloud.user.center.domain.repository;

import com.github.spring.cloud.user.center.domain.entity.SystemMIdRoleMenuDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色和菜单中间表
 * <p>
 * create in 2021/4/14 7:56 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemMidRoleMenuRepository extends JpaRepository<SystemMIdRoleMenuDO, Long> {
}
