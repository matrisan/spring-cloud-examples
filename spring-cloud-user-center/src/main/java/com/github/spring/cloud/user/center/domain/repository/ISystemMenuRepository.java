package com.github.spring.cloud.user.center.domain.repository;

import com.github.spring.cloud.user.center.domain.entity.SystemMenuDO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 菜单仓储
 * <p>
 * create in 2021/4/14 7:57 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@CacheConfig(cacheNames = "manager:menu")
public interface ISystemMenuRepository extends JpaRepository<SystemMenuDO, Long> {
}
