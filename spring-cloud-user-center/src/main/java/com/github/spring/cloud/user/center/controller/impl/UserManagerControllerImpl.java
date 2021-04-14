package com.github.spring.cloud.user.center.controller.impl;

import com.github.spring.boot.common.framework.ResultVO;
import com.github.spring.cloud.user.center.controller.IUserManagerController;
import com.github.spring.cloud.user.center.pojo.vo.ISystemUserVO;
import com.github.spring.cloud.user.center.repository.ISystemUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/4/14 7:03 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@RestController
@PreAuthorize("hasAnyRole('ROLE_ROOT')")
public class UserManagerControllerImpl implements IUserManagerController {

    @Resource
    private ISystemUserRepository repository;

    @GetMapping("users")
    @Override
    public ResultVO<Page<ISystemUserVO>> findAllUsers(Pageable pageable) {
        return ResultVO.success(repository.findAllBy(pageable, ISystemUserVO.class));
    }
}
