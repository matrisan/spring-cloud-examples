package com.github.spring.cloud.user.center.domain.manager.impl;

import com.github.spring.cloud.user.center.domain.aggregate.ISystemUserMapper;
import com.github.spring.cloud.user.center.domain.entity.SystemMidUserRoleDO;
import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.domain.manager.ISystemUserManager;
import com.github.spring.cloud.user.center.domain.repository.ISystemMidUserRoleRepository;
import com.github.spring.cloud.user.center.domain.repository.ISystemUserRepository;
import com.github.spring.cloud.user.center.interfaces.dto.UserCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserUpdateCommandDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
@Component
public class SystemUserManagerImpl implements ISystemUserManager {

    @Resource
    private ISystemUserRepository userRepository;

    @Resource
    private ISystemMidUserRoleRepository midUserRoleRepository;

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByMobile(String mobile) {
        return userRepository.existsByMobile(mobile);
    }

    @Override
    public String findCurrentPassword() {
        return userRepository.findCurrentPassword();
    }

    @Override
    public SystemUserDO findSimpleUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public SystemUserDO findSimpleUserByUsername(String username) {
        return userRepository.findByUsernameEquals(username);
    }

    @Override
    public SystemUserDO findSimpleUserByMobile(String mobile) {
        return userRepository.findByMobileEquals(mobile);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public UserSaveResultDTO createSimpleUser(UserCreateCommandDTO simpleUser) {
        SystemUserDO rawUser = ISystemUserMapper.INSTANCE.from(simpleUser);
        SystemUserDO ripeUser = userRepository.save(rawUser);
        if (CollectionUtils.isNotEmpty(simpleUser.getRoleIds())) {
            simpleUser.getRoleIds().forEach(aLong -> midUserRoleRepository.save(new SystemMidUserRoleDO(ripeUser.getId(), aLong)));
        }
        return ISystemUserMapper.INSTANCE.from(ripeUser);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public UserSaveResultDTO updateSimpleUser(UserUpdateCommandDTO simpleUser) {
        SystemUserDO rawUser = ISystemUserMapper.INSTANCE.from(simpleUser);
        SystemUserDO ripeUser = userRepository.save(rawUser);
        midUserRoleRepository.deleteAllByUserId(rawUser.getId());
        if (CollectionUtils.isNotEmpty(simpleUser.getRoleIds())) {
            simpleUser.getRoleIds().forEach(aLong -> midUserRoleRepository.save(new SystemMidUserRoleDO(ripeUser.getId(), aLong)));
        }
        return ISystemUserMapper.INSTANCE.from(ripeUser);
    }

    @Override
    public void deleteSimpleUser(SystemUserDO simpleUser) {
        userRepository.delete(simpleUser);
    }
}
