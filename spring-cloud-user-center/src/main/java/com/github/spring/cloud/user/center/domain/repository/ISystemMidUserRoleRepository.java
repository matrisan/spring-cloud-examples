package com.github.spring.cloud.user.center.domain.repository;

import com.github.spring.cloud.user.center.domain.entity.SystemMidUserRoleDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 用户角色中间表
 * <p>
 * create in 2021/4/14 7:56 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SuppressWarnings("unchecked")
@CacheConfig(cacheNames = "manager:user-role")
public interface ISystemMidUserRoleRepository extends JpaRepository<SystemMidUserRoleDO, Long> {

    /**
     * 保存用户角色
     *
     * @param midUserRole 用户角色
     * @return SystemMidUserRoleDO
     */
    @Override
    @NotNull
    SystemMidUserRoleDO save(@NotNull SystemMidUserRoleDO midUserRole);

    int deleteAllByUserId(long userId);


    /**
     * 用户 ID
     *
     * @param userId 用户 ID
     * @return List
     */
    List<SystemMidUserRoleDO> findByUserId(long userId);

    /**
     * 根据用户 ID 查找所有的角色 ID
     *
     * @param userId 用户的 ID
     * @return List
     */
    @Query("SELECT m.roleId FROM SystemMidUserRoleDO AS m WHERE m.userId = :userId")
    @Cacheable(key = "'user-id:' + #a0")
    List<Long> findRoleIdsByUserId(long userId);

    /**
     * 判断用户角色是否存在
     *
     * @param userId 用户的 ID
     * @param roleId 角色的 ID
     * @return boolean
     */
    boolean existsByUserIdAndRoleId(long userId, long roleId);

}
