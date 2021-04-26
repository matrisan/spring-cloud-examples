package com.github.spring.cloud.statistics.application.service;

import com.github.spring.cloud.statistics.interfaces.dto.IMinuteActiveUserDTO;
import com.github.spring.cloud.statistics.interfaces.dto.MinuteActiveUserCommandDTO;
import com.github.spring.cloud.statistics.interfaces.dto.QueryMinuteActiveUserDTO;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/4/25 5:40 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IMinuteActiveUserService {

    List<IMinuteActiveUserDTO> queryMau(QueryMinuteActiveUserDTO queryMau);

    void save(MinuteActiveUserCommandDTO mau);

}
