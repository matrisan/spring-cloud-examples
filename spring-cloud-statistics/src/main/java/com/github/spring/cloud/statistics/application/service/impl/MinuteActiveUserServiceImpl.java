package com.github.spring.cloud.statistics.application.service.impl;

import com.github.spring.cloud.statistics.application.service.IMinuteActiveUserService;
import com.github.spring.cloud.statistics.domain.aggregate.IMinuteActiveUserAggregate;
import com.github.spring.cloud.statistics.domain.repository.IActiveUserMinuteRepository;
import com.github.spring.cloud.statistics.interfaces.dto.IMinuteActiveUserDTO;
import com.github.spring.cloud.statistics.interfaces.dto.MinuteActiveUserCommandDTO;
import com.github.spring.cloud.statistics.interfaces.dto.QueryMinuteActiveUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/4/25 5:47 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class MinuteActiveUserServiceImpl implements IMinuteActiveUserService {

    @Resource
    private IActiveUserMinuteRepository repository;

    @Override
    public List<IMinuteActiveUserDTO> queryMau(QueryMinuteActiveUserDTO queryMau) {
        return repository.findByHostnameInAndDateTimeBetween(queryMau.getHostname(), queryMau.getStartTime(), queryMau.getEndTime());
    }

    @Override
    public void save(MinuteActiveUserCommandDTO mau) {
        repository.save(IMinuteActiveUserAggregate.INSTANCE.from(mau));
    }
}
