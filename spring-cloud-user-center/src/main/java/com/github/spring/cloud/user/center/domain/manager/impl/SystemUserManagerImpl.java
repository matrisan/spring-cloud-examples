package com.github.spring.cloud.user.center.domain.manager.impl;

import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.domain.manager.ISystemUserManager;
import com.github.spring.cloud.user.center.domain.repository.ISystemUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/4/17 4:43 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@CacheConfig(cacheNames = "manager:user")
public class SystemUserManagerImpl implements ISystemUserManager {

    @Resource
    private ISystemUserRepository repository;


    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }


    @Override
    public boolean existsByMobile(String mobile) {
        return repository.existsByMobile(mobile);
    }


    @Override
    public String findCurrentPassword() {
        return null;
    }


    @Override
    public SystemUserDO findSimpleUserById(long id) {
        return repository.findById(id);
    }


    @Override
    public SystemUserDO findSimpleUserByUsername(String username) {
        return repository.findByUsernameEquals(username);
    }


    @Override
    public SystemUserDO findSimpleUserByMobile(String mobile) {
        return repository.findByMobileEquals(mobile);
    }


    @Override
    public SystemUserDO saveSimpleUser(SystemUserDO simpleUser) {
        return repository.save(simpleUser);
    }


    @Override
    public void deleteSimpleUser(SystemUserDO simpleUser) {
        repository.delete(simpleUser);
    }
}
