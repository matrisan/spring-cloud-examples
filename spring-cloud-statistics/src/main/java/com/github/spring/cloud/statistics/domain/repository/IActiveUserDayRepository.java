package com.github.spring.cloud.statistics.domain.repository;

import com.github.spring.cloud.statistics.domain.entity.ActiveUserDayDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 * <p>
 * create in 2021/4/25 5:27 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IActiveUserDayRepository extends JpaRepository<ActiveUserDayDO, Long> {
}
