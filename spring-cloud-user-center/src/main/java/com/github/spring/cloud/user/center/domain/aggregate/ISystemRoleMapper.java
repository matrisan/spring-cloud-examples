package com.github.spring.cloud.user.center.domain.aggregate;

import com.github.spring.cloud.user.center.domain.entity.SystemRoleDO;
import com.github.spring.cloud.user.center.interfaces.dto.IRoleSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.RoleUpdateCommandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TODO
 * <p>
 * create in 2021/4/26 7:46 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Mapper
public interface ISystemRoleMapper {

    ISystemRoleMapper INSTANCE = Mappers.getMapper(ISystemRoleMapper.class);

    SystemRoleDO from(RoleCreateCommandDTO createRole);

    SystemRoleDO from(RoleUpdateCommandDTO createRole);

    IRoleSaveResultDTO from(SystemRoleDO role);

}
