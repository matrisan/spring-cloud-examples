package com.github.spring.cloud.user.center.repository;

import com.github.spring.cloud.user.center.pojo.entity.SystemMenuDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 * <p>
 * create in 2021/4/14 7:57 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemMenuRepository extends JpaRepository<SystemMenuDO, Long> {
}
