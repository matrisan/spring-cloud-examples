package com.github.spring.cloud.user.center.domain.repository;

import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 用户仓储
 * <p>
 * create in 2021/4/2 5:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SuppressWarnings("unchecked")
@CacheConfig(cacheNames = "manager:user")
public interface ISystemUserRepository extends JpaRepository<SystemUserDO, Long>, JpaSpecificationExecutor<SystemUserDO>, RevisionRepository<SystemUserDO, Long, Integer> {

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    @Cacheable(key = "'exist:username:' + #a0", unless = "#result != null")
    boolean existsByUsernameEquals(String username);

    /**
     * 根据手机号码判断欧诺个户是否存在
     *
     * @param mobile 手机号码
     * @return boolean
     */
    @Cacheable(key = "'exist:mobile:' + #a0", unless = "#result != null")
    boolean existsByMobileEquals(String mobile);

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
    @Cacheable(key = "'password:username:' + {#principal.username}", condition = "#result != null", sync = true)
    @Query("SELECT user.password FROM SystemUserDO AS user WHERE user.username = :#{principal.username}")
    String findCurrentPassword();

    /**
     * 根据当前用户的 ID 查找用户
     *
     * @param id 用户的 ID
     * @return 用户信息
     */
    @Cacheable(key = "'id:' + #a0")
    SystemUserDO findById(long id);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return SystemUserDO
     */
    @Cacheable(key = "'username:' + #a0")
    SystemUserDO findByUsernameEquals(String username);

    /**
     * 根据手机号码查询用户
     *
     * @param mobile 电话号码
     * @return SystemUserDO
     */
    @Cacheable(key = "'mobile:' + #a0")
    SystemUserDO findByMobileEquals(String mobile);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return Optional
     */
    @Cacheable(key = "'id:' + #a0", unless = "!#result.present")
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


    /**
     * 保存用户信息
     *
     * @param simpleUser 用户信息
     * @return SystemUserDO
     */
    @Caching(put = {
            @CachePut(key = "'id:' + #result.id"),
            @CachePut(key = "'username:' + #result.username"),
            @CachePut(key = "'mobile:' + #result.mobile")
    })
    @Override
    @NotNull SystemUserDO save(@NotNull SystemUserDO simpleUser);

    /**
     * 删除用户
     *
     * @param simpleUser 用户信息
     */
    @Caching(evict = {
            @CacheEvict(key = "'id:' + #a0.id"),
            @CacheEvict(key = "'username:' + #a0.username"),
            @CacheEvict(key = "'current:password:' + #a0.username"),
            @CacheEvict(key = "'mobile:' + #a0.mobile"),
            @CacheEvict(key = "'exist:username:' + #a0.username"),
            @CacheEvict(key = "'exist:mobile:' + #a0.mobile")
    })
    @Override
    void delete(@NotNull SystemUserDO simpleUser);
}
