package com.github.spring.cloud.user.center.application.service.impl;

import com.github.spring.cloud.user.center.application.service.ISystemUserService;
import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.domain.manager.ISystemUserManager;
import com.github.spring.cloud.user.center.interfaces.dto.UserCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserQueryDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserUpdateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.vo.ISystemUserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务类
 * <p>
 * create in 2021/4/2 5:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class SystemUserServiceImpl implements UserDetailsService, ISystemUserService {

    private final ISystemUserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userManager.findSimpleUserByUsername(username);
    }

    /**
     * 根据手机号码查找用户
     *
     * @param mobile 手机号码
     * @return UserDetails
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        return userManager.findSimpleUserByMobile(mobile);
    }

    @Override
    public Page<ISystemUserVO> findAllUsers(UserQueryDTO user, Pageable pageable) {
//        return userRepository.findAll(specification(user), pageable).map(systemUserDO -> null);
        return null;
    }

    @Override
    public UserSaveResultDTO createUser(UserCreateCommandDTO user) {
        return userManager.createSimpleUser(user);
    }

    @Override
    public UserSaveResultDTO updateUser(UserUpdateCommandDTO user) {
        return userManager.updateSimpleUser(user);
    }

    @Override
    public void deleteByUserId(SystemUserDO user) {
        userManager.deleteSimpleUser(user);
    }

    private Specification<SystemUserDO> specification(UserQueryDTO user) {
        return (root, query, builder) -> {
            List<Predicate> list = new ArrayList<>();
            if (StringUtils.isNotBlank(user.getUsername())) {
                Predicate predicateParent = builder.equal(root.get("username").as(Long.class), user.getUsername());
                list.add(predicateParent);
            }
            Predicate[] predicates = list.toArray(new Predicate[0]);
            return query.where(predicates).getRestriction();
        };
    }

}
