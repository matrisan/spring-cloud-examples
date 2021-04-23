package com.github.spring.cloud.user.center.domain.manager;

import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;

/**
 * TODO
 * <p>
 * create in 2021/4/14 7:24 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserDetailManager {

    /**
     * 根据用户名查找用户
     *
     * @param username 用户密码
     * @return SystemUserDO
     */
    SystemUserDO loadUserByUsername(String username);

}
