package com.github.spring.cloud.user.center.domain.aggregate;

import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.interfaces.dto.UserCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserUpdateCommandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * User 数据转换
 * <p>
 * create in 2021/4/23 5:57 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Mapper
public interface ISystemUserMapper {

    ISystemUserMapper INSTANCE = Mappers.getMapper(ISystemUserMapper.class);

    /**
     * 数据转换
     *
     * @param createCommand 创建信息
     * @return SystemUserDO
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "credentialsNonExpired", ignore = true)
    @Mapping(target = "accountNonLocked", ignore = true)
    @Mapping(target = "accountNonExpired", ignore = true)
    @Mapping(target = "lastLoginDate", ignore = true)
    SystemUserDO from(UserCreateCommandDTO createCommand);

    /**
     * 数据转换
     *
     * @param createCommand 更新信息
     * @return SystemUserDO
     */
    SystemUserDO from(UserUpdateCommandDTO createCommand);

    /**
     * 数据库数据转 DTO
     *
     * @param userDO SystemUserDO
     * @return UserSaveResultDTO
     */
    UserSaveResultDTO from(SystemUserDO userDO);

}
