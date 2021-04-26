package com.github.spring.cloud.statistics.domain.aggregate;

import com.github.spring.cloud.statistics.domain.entity.ActiveUserMinuteDO;
import com.github.spring.cloud.statistics.interfaces.dto.MinuteActiveUserCommandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TODO
 * <p>
 * create in 2021/4/25 10:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Mapper
public interface IMinuteActiveUserAggregate {

    IMinuteActiveUserAggregate INSTANCE = Mappers.getMapper(IMinuteActiveUserAggregate.class);

    ActiveUserMinuteDO from(MinuteActiveUserCommandDTO command);

}
