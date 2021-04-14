package com.github.spring.cloud.user.center.repository;

import com.github.spring.cloud.user.center.pojo.entity.SystemUserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/4/2 5:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */


public interface ISystemUserRepository extends JpaRepository<SystemUserDO, Long>, JpaSpecificationExecutor<SystemUserDO> {

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    boolean existsByUsername(String username);

    boolean existsByMobile(String mobile);



    /**
     * 查找所有的用户
     *
     * @param pageable 分页信息
     * @param clz      返回的字段
     * @param <T>      泛型信息
     * @return Page
     */
    <T> Page<T> findAllBy(Pageable pageable, Class<T> clz);

    /**
     * 获取当前登录的用户密码（加密过后的密码）
     *
     * @return String
     */
    @Query("SELECT user.password FROM SystemUserDO AS user WHERE user.username = :#{principal.username}")
    String findCurrentPassword();

    /**
     * 根据当前用户的 ID 查找用户
     *
     * @param id 用户的 ID
     * @return 用户信息
     */
    SystemUserDO findById(long id);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return SystemUserDO
     */
    SystemUserDO findByUsernameEquals(String username);

    Optional<SystemUserDO> findByUsername(String username);

    /**
     * 更新当前登录用户的密码，会自动加密
     *
     * @param password 密码
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE SystemUserDO AS user SET user.password = :password WHERE user.username = :#{principal.username}")
    void updateCurrentPassword(String password);

    /**
     * 更新用户最后登录时间id
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE SystemUserDO AS user SET user.lastLoginDate = CURRENT_TIMESTAMP WHERE user.username = :#{principal.username}")
    void updateLastLoginDate();


}
