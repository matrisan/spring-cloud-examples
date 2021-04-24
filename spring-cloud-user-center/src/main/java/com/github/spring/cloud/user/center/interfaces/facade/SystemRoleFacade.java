package com.github.spring.cloud.user.center.interfaces.facade;

import com.github.spring.boot.common.framework.ResultVO;
import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleQueryDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleUpdateCommandDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * TODO
 * <p>
 * create in 2021/4/23 6:54 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@RestController
@PreAuthorize("hasAnyRole('ROLE_ROOT')")
public class SystemRoleFacade {

    public ResultVO<Page<RoleQueryDTO>> findAllRoles(RoleQueryDTO query, Pageable pageable) {
        return ResultVO.success();
    }

    @PostMapping("role")
    public ResultVO<RoleSaveResultDTO> createUser(@RequestBody @Valid RoleCreateCommandDTO user) {
        return ResultVO.success();
    }

    @PutMapping("role")
    public ResultVO<RoleSaveResultDTO> updateUser(@RequestBody @Valid RoleUpdateCommandDTO user) {
        return ResultVO.success();
    }

    @DeleteMapping("role/{id}")
    public ResultVO<Void> deleteById(@PathVariable SystemUserDO user) {
        return ResultVO.success();
    }


}
