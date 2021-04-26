package com.github.spring.cloud.statistics.domain.repository;

import com.github.spring.cloud.statistics.domain.entity.ActiveUserMinuteDO;
import com.github.spring.cloud.statistics.interfaces.dto.IMinuteActiveUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/4/25 5:28 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IActiveUserMinuteRepository extends JpaRepository<ActiveUserMinuteDO, Long> {

    List<IMinuteActiveUserDTO> findByHostnameInAndDateTimeBetween(Collection<String> hostnames, LocalDateTime startDate, LocalDateTime endDate);

}
