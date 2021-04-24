package com.github.spring.cloud.user.center.domain.aggregate;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 中间表转换类
 * <p>
 * create in 2021/4/24 10:00 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Mapper
public interface ISystemMidUserRoleMapper {

    ISystemMidUserRoleMapper INSTANCE = Mappers.getMapper(ISystemMidUserRoleMapper.class);


}
