package com.github.spring.cloud.user.center.application.service;

import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.interfaces.dto.UserCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserQueryDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserUpdateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.vo.ISystemUserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

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
     * 根据手机号码查询用户
     *
     * @param mobile 手机号码
     * @return SystemUserDO
     */
    UserDetails loadUserByMobile(String mobile);

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
    UserSaveResultDTO createUser(UserCreateCommandDTO user);

    /**
     * 更新用户
     *
     * @param user 用户信息
     * @return 用户
     */
    UserSaveResultDTO updateUser(UserUpdateCommandDTO user);

    /**
     * 删除用户
     *
     * @param user 用户
     */
    void deleteByUserId(SystemUserDO user);

}
