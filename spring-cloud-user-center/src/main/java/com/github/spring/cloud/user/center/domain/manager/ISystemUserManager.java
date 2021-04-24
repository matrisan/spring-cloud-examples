package com.github.spring.cloud.user.center.domain.manager;

import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.interfaces.dto.UserCreateCommandDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserSaveResultDTO;
import com.github.spring.cloud.user.center.interfaces.dto.UserUpdateCommandDTO;

/**
 * 用户管理类
 * <p>
 * create in 2021/4/17 4:37 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemUserManager {

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    boolean existsByUsername(String username);

    /**
     * 根据手机号码判断欧诺个户是否存在
     *
     * @param mobile 手机号码
     * @return boolean
     */
    boolean existsByMobile(String mobile);

    /**
     * 获取当前登录的用户密码（加密过后的密码）
     *
     * @return String
     */
    String findCurrentPassword();

    /**
     * 根据当前用户的 ID 查找用户
     *
     * @param id 用户的 ID
     * @return 用户信息
     */
    SystemUserDO findSimpleUserById(long id);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return SystemUserDO
     */
    SystemUserDO findSimpleUserByUsername(String username);

    /**
     * 根据手机号码查询用户
     *
     * @param mobile 手机号码
     * @return SystemUserDO
     */
    SystemUserDO findSimpleUserByMobile(String mobile);

    /**
     * 保存用户信息
     * 同时将用户的 id,用户名,手机号码,密码存入 缓存
     *
     * @param simpleUser 用户信息
     * @return UserSaveResultDTO
     */
    UserSaveResultDTO createSimpleUser(UserCreateCommandDTO simpleUser);

    /**
     * 更新用户
     *
     * @param simpleUser 用户
     * @return UserSaveResultDTO
     */
    UserSaveResultDTO updateSimpleUser(UserUpdateCommandDTO simpleUser);

    /**
     * 删除用户
     *
     * @param simpleUser 用户信息
     */
    void deleteSimpleUser(SystemUserDO simpleUser);
}
