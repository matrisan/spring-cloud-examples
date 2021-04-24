package com.github.spring.cloud.user.center.application.service.impl;

import com.github.spring.cloud.user.center.application.service.ISystemMenuService;
import com.github.spring.cloud.user.center.domain.entity.SystemMenuDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * 菜单管理
 * <p>
 * create in 2021/4/17 4:33 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class SystemMenuServiceImpl implements ISystemMenuService {

    @Override
    public Page<SystemMenuDO> findAll() {
        return null;
    }

    @Override
    public SystemMenuDO updateMenu(SystemMenuDO menu) {
        return null;
    }
}
