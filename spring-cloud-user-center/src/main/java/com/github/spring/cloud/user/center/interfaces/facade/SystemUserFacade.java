package com.github.spring.cloud.user.center.interfaces.facade;

import com.github.spring.boot.common.framework.ResultVO;
import com.github.spring.cloud.user.center.application.service.ISystemUserService;
import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.interfaces.dto.UserCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserQueryDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserUpdateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.vo.ISystemUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

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
public class SystemUserFacade {

    @Resource
    private ISystemUserService service;

    @GetMapping("users")
    public ResultVO<Page<ISystemUserVO>> findAllUsers(UserQueryDTO user, Pageable pageable) {
        return ResultVO.success(service.findAllUsers(user, pageable));
    }

    @PostMapping("user")
    public ResultVO<UserSaveResultDTO> createUser(@RequestBody @Valid UserCreateCommandDTO user) {
        return ResultVO.success();
    }

    @PutMapping("user")
    public ResultVO<UserSaveResultDTO> updateUser(@RequestBody @Valid UserUpdateCommandDTO user) {
        return ResultVO.success();
    }

    @DeleteMapping("user/{id}")
    public ResultVO<Void> deleteById(@PathVariable SystemUserDO user) {
        return ResultVO.success();
    }
}
