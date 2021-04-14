package com.github.spring.cloud.user.center.repository;

import com.github.spring.cloud.user.center.pojo.entity.SystemRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/4/2 5:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */


public interface ISystemRoleRepository extends JpaRepository<SystemRoleDO, Long> {

    SystemRoleDO findByRoleCode(String roleCode);

    boolean existsByRoleCode(String roleCoDe);

    @Query("SELECT role FROM SystemRoleDO AS role WHERE role.id IN (SELECT mur.roleId FROM SystemMidUserRoleDO AS mur WHERE mur.userId=:userId)")
    List<SystemRoleDO> findSystemRoleByUserId(long userId);

}
