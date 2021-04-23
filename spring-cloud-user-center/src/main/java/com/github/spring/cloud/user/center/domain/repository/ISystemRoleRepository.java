package com.github.spring.cloud.user.center.domain.repository;

import com.github.spring.cloud.user.center.domain.entity.SystemRoleDO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 角色仓储
 * <p>
 * create in 2021/4/2 5:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@CacheConfig(cacheNames = "manager:role")
public interface ISystemRoleRepository extends JpaRepository<SystemRoleDO, Long> {

    /**
     * 根据角色的 CODE 查询角色
     *
     * @param roleCode 角色的 ID
     * @return 角色
     */
    SystemRoleDO findByRoleCode(String roleCode);

    /**
     * @param roleCoDe
     * @return
     */
    boolean existsByRoleCode(String roleCoDe);

    /**
     * 根据
     *
     * @param userId 用户的 ID
     * @return list
     */
    @Query("SELECT role FROM SystemRoleDO AS role WHERE role.id IN (SELECT mur.roleId FROM SystemMidUserRoleDO AS mur WHERE mur.userId=:userId)")
    List<SystemRoleDO> findSystemRoleByUserId(long userId);

}
