package com.github.spring.cloud.user.center.service.impl;

import com.github.spring.cloud.user.center.pojo.dto.SystemUserServiceDTO;
import com.github.spring.cloud.user.center.pojo.dto.QueryUserDTO;
import com.github.spring.cloud.user.center.pojo.entity.SystemUserDO;
import com.github.spring.cloud.user.center.pojo.vo.ISystemUserVO;
import com.github.spring.cloud.user.center.repository.ISystemUserRepository;
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
 * TODO
 * <p>
 * create in 2021/4/14 9:57 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class SystemUserService {

    private final ISystemUserRepository userRepository;

    public Page<ISystemUserVO> findAllUsers(QueryUserDTO user, Pageable pageable) {
        return userRepository.findAll(specification(user), pageable).map(systemUserDO -> null);
    }

    public SystemUserDO createUser(SystemUserServiceDTO user) {
        return userRepository.save(user.toSystemUser());
    }

    public SystemUserDO updateUser(SystemUserServiceDTO user) {
        return userRepository.save(user.toSystemUser());
    }

    public void deleteByUserId(SystemUserDO user) {
        userRepository.delete(user);
    }

    private Specification<SystemUserDO> specification(QueryUserDTO user) {
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
