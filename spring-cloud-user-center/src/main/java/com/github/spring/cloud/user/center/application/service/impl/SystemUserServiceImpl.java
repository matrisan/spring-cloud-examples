package com.github.spring.cloud.user.center.application.service.impl;

import com.github.spring.cloud.user.center.application.service.ISystemUserService;
import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.domain.manager.ISystemRoleManager;
import com.github.spring.cloud.user.center.domain.manager.ISystemUserManager;
import com.github.spring.cloud.user.center.interfaces.dto.SystemUserServiceDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserQueryDTO;
import com.github.spring.cloud.user.center.interfaces.vo.ISystemUserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务类
 * <p>
 * create in 2021/4/14 9:57 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class SystemUserServiceImpl implements ISystemUserService {

    private final ISystemUserManager userManager;

    private final ISystemRoleManager roleManager;

    @Override
    public SystemUserDO loadUserByUsername(String username) {
        return userManager.findSimpleUserByUsername(username);
    }

    @Override
    public SystemUserDO loadUserByMobile(String mobile) {
        return userManager.findSimpleUserByMobile(mobile);
    }

    @Override
    public Page<ISystemUserVO> findAllUsers(UserQueryDTO user, Pageable pageable) {
        return userRepository.findAll(specification(user), pageable).map(systemUserDO -> null);
    }

    @Override
    public SystemUserDO createUser(SystemUserServiceDTO user) {
        return userManager.saveSimpleUser(user.toSystemUser());
    }

    @Override
    public SystemUserDO updateUser(SystemUserServiceDTO user) {
        return userManager.saveSimpleUser(user.toSystemUser());
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
