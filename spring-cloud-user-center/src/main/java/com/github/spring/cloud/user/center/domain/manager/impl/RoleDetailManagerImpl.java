package com.github.spring.cloud.user.center.domain.manager.impl;

import com.github.spring.cloud.user.center.domain.entity.SystemRoleDO;
import com.github.spring.cloud.user.center.domain.manager.IRoleDetailManager;
import com.github.spring.cloud.user.center.domain.repository.ISystemRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/4/14 11:03 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
@CacheConfig(cacheNames = "manager:role")
public class RoleDetailManagerImpl implements IRoleDetailManager {

    @Resource
    private ISystemRoleRepository roleRepository;

    @Caching(cacheable = {
            @Cacheable(key = "'id:' + #a0"),
            @Cacheable(key = "'code:' + #result.roleCode")
    })
    @Override
    public SystemRoleDO findById(long id) {
        SystemRoleDO role = roleRepository.getOne(id);
        log.debug("根据 ID 查询:{} - 查询结果:{}", id, role);
        return role;
    }

    @Cacheable(key = "'code:' + #a0")
    @Override
    public SystemRoleDO findByRoleCode(String roleCode) {
        return null;
    }

    @Override
    public boolean existsByRoleCode(String roleCode) {
        return roleRepository.existsByRoleCode(roleCode);
    }

    @Caching(put = {
            @CachePut(key = "'id:' + #result.id"),
            @CachePut(key = "'code:' + #result.roleCode")
    })
    @Override
    public SystemRoleDO save(SystemRoleDO systemRole) {
        SystemRoleDO role = roleRepository.save(systemRole);
        log.debug("新增角色:{}", systemRole);
        return role;
    }

    @Caching(put = {
            @CachePut(key = "'id:' + #result.id"),
            @CachePut(key = "'code:' + #result.roleCode")
    })
    @Override
    public SystemRoleDO updateRole(SystemRoleDO systemRole) {
        SystemRoleDO role = roleRepository.save(systemRole);
        log.debug("修改角色:{}", systemRole);
        return role;
    }

    @Caching(evict = {
            @CacheEvict(key = "'id:' + #a0"),
            @CacheEvict(key = "'code:' + #result.roleCode")
    })
    @Override
    public void deleteRole(SystemRoleDO systemRole) {
        roleRepository.delete(systemRole);
    }
}
