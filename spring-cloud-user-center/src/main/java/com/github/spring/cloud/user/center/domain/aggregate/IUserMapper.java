package com.github.spring.cloud.user.center.domain.aggregate;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TODO
 * <p>
 * create in 2021/4/23 5:57 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Mapper(componentModel = "spring")
public interface IUserMapper {

    IUserMapper MAPPER = Mappers.getMapper(IUserMapper.class);

//    @Mappings({
//            @Mapping(source = "userDO.name", target = "name"),
//            @Mapping(source = "userPO.info", target = "info"),
//            @Mapping(source = "userPO.age", target = "age")
//    })
//    UserVO from(UserDO userDO, UserPO userPO);


}
