package com.github.spring.cloud.user.center.application.service;

import com.github.spring.cloud.user.center.domain.entity.SystemMenuDO;
import org.springframework.data.domain.Page;

/**
 * TODO
 * <p>
 * create in 2021/4/17 4:31 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemMenuService {

    Page<SystemMenuDO> findAll();

    SystemMenuDO updateMenu(SystemMenuDO menu);


}
