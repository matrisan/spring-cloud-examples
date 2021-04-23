package com.github.spring.cloud.user.center.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * TODO
 * <p>
 * create in 2021/4/2 5:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final ISystemUserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return service.loadUserByUsername(username);
    }

    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        return service.loadUserByMobile(mobile);
    }

}
