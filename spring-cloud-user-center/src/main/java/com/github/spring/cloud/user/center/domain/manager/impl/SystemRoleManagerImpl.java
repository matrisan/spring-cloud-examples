package com.github.spring.cloud.user.center.domain.manager.impl;

import com.github.spring.cloud.user.center.domain.aggregate.ISystemRoleMapper;
import com.github.spring.cloud.user.center.domain.entity.SystemMidRoleMenuDO;
import com.github.spring.cloud.user.center.domain.entity.SystemRoleDO;
import com.github.spring.cloud.user.center.domain.manager.ISystemRoleManager;
import com.github.spring.cloud.user.center.domain.repository.ISystemMidRoleMenuRepository;
import com.github.spring.cloud.user.center.domain.repository.ISystemRoleRepository;
import com.github.spring.cloud.user.center.interfaces.dto.IRoleQueryResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.IRoleSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleQueryDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleUpdateCommandDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * TODO
 * <p>
 * create in 2021/4/24 4:17 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class SystemRoleManagerImpl implements ISystemRoleManager {

    private static final ISystemRoleMapper INSTANCE = ISystemRoleMapper.INSTANCE;

    @Resource
    private ISystemRoleRepository roleRepository;

    @Resource
    private ISystemMidRoleMenuRepository midRoleMenuRepository;

    @Override
    public Page<IRoleQueryResultDTO> findAllRoles(RoleQueryDTO queryRole, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<IRoleQueryResultDTO> findById(long id) {
        return null;
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public IRoleSaveResultDTO createRole(RoleCreateCommandDTO createRole) {
        SystemRoleDO role = roleRepository.save(INSTANCE.from(createRole));
        List<SystemMidRoleMenuDO> collect = createRole.getMenuIds().stream().map(x -> getRoleMenu(role, x)).collect(Collectors.toList());
        midRoleMenuRepository.saveAll(collect);
        return INSTANCE.from(role);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public IRoleSaveResultDTO updateRole(RoleUpdateCommandDTO createRole) {
        SystemRoleDO role = roleRepository.save(INSTANCE.from(createRole));
        List<SystemMidRoleMenuDO> toUpdate = createRole.getMenuIds().stream().map(x -> getRoleMenu(role, x)).collect(Collectors.toList());
        List<SystemMidRoleMenuDO> dbData = midRoleMenuRepository.findByRoleIdEquals(role.getId());
        Collection<SystemMidRoleMenuDO> toSave = CollectionUtils.subtract(toUpdate, dbData);
        Collection<SystemMidRoleMenuDO> toRemove = CollectionUtils.subtract(dbData, toUpdate);
        midRoleMenuRepository.deleteAll(toRemove);
        midRoleMenuRepository.saveAll(toSave);
        return INSTANCE.from(role);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public int deleteRoleById(SystemRoleDO role) {
        log.info("删除角色:{}", role);
        midRoleMenuRepository.deleteByRoleIdEquals(role.getId());
        roleRepository.delete(role);
        return 0;
    }

    private SystemMidRoleMenuDO getRoleMenu(SystemRoleDO role, Long x) {
        return SystemMidRoleMenuDO.builder().roleId(role.getId()).menuId(x).build();
    }
}
