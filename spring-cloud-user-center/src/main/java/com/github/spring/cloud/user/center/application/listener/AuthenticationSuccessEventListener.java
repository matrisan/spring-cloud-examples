package com.github.spring.cloud.user.center.application.listener;

import com.github.spring.cloud.user.center.domain.repository.ISystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 下午11:19 2020/5/12
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationSuccessEventListener {

    private final ISystemUserRepository repository;

    /**
     * 用户认证成功监听器
     */
    @EventListener(value = InteractiveAuthenticationSuccessEvent.class)
    public void authenticationSuccessEvent() {
        log.debug("更新最后登录成功时间");
        repository.updateLastLoginDate();
    }

}
