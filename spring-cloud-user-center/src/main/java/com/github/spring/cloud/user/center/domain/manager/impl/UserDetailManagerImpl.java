package com.github.spring.cloud.user.center.domain.manager.impl;

import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.domain.manager.IUserDetailManager;
import com.github.spring.cloud.user.center.domain.repository.ISystemMidUserRoleRepository;
import com.github.spring.cloud.user.center.domain.repository.ISystemRoleRepository;
import com.github.spring.cloud.user.center.domain.repository.ISystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/4/14 7:24 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailManagerImpl implements IUserDetailManager {

    private final ISystemUserRepository userRepository;

    private final ISystemRoleRepository roleRepository;

    private final ISystemMidUserRoleRepository userRoleRepository;

    @Override
    public SystemUserDO loadUserByUsername(String username) {
        Optional<SystemUserDO> optional = userRepository.findByUsername(username);
        if (!optional.isPresent()) {
            log.debug("用户不存在:{}", username);
            throw new UsernameNotFoundException(username + ":用户不存在");
        }
        SystemUserDO user = optional.get();
        List<Long> roleId = userRoleRepository.findRoleIdsByUserId(user.getId());
        // TODO
        user.setRoles(roleRepository.findSystemRoleByUserId(user.getId()));
        log.debug("查找到用户:{}", user);
        return user;
    }
}
