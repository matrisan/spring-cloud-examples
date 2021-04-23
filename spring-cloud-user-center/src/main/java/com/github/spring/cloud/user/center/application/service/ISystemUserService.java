package com.github.spring.cloud.user.center.application.service;

import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.interfaces.dto.SystemUserServiceDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserQueryDTO;
import com.github.spring.cloud.user.center.interfaces.vo.ISystemUserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 用户服务
 * <p>
 * create in 2021/4/16 11:04 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemUserService {

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return SystemUserDO
     */
    SystemUserDO loadUserByUsername(String username);

    SystemUserDO loadUserByMobile(String mobile);

    /**
     * 查找所有用户信息
     *
     * @param user     查询条件
     * @param pageable 分页信息
     * @return Page
     */
    Page<ISystemUserVO> findAllUsers(UserQueryDTO user, Pageable pageable);

    /**
     * 创建用户
     *
     * @param user 用户信息
     * @return 用户
     */
    SystemUserDO createUser(SystemUserServiceDTO user);

    /**
     * 更新用户
     *
     * @param user 用户信息
     * @return 用户
     */
    SystemUserDO updateUser(SystemUserServiceDTO user);

    /**
     * 删除用户
     *
     * @param user 用户
     */
    void deleteByUserId(SystemUserDO user);

}
