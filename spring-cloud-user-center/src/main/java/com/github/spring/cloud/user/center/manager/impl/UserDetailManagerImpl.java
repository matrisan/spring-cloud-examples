package com.github.spring.cloud.user.center.manager.impl;

import com.github.spring.cloud.user.center.manager.IUserDetailManager;
import com.github.spring.cloud.user.center.pojo.entity.SystemUserDO;
import com.github.spring.cloud.user.center.repository.ISystemRoleRepository;
import com.github.spring.cloud.user.center.repository.ISystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

    @Override
    public SystemUserDO loadUserByUsername(String username) {
        Optional<SystemUserDO> optional = userRepository.findByUsername(username);
        if (!optional.isPresent()) {
            log.debug("用户不存在:{}", username);
            throw new UsernameNotFoundException(username + ":用户不存在");
        }
        SystemUserDO user = optional.get();
        user.setRoles(roleRepository.findSystemRoleByUserId(user.getId()));
        log.debug("查找到用户:{}", user);
        return user;
    }
}
