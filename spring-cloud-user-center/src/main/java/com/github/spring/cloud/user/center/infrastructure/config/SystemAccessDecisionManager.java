package com.github.spring.cloud.user.center.infrastructure.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;

import java.util.List;

/**
 * 生成决策器到容器中会自动生效，
 * <p>
 * create in 2021/1/14 7:00 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
//@Component
@RequiredArgsConstructor
public class SystemAccessDecisionManager {

    /**
     * ConsensusBased 基于共识的决策器。 用户持有同意的角色数量多于禁止的角色数。
     * UnanimousBased 基于一致的决策器。 用户持有的所有角色都同意访问才能放行。
     *
     * @param decisionVoters 基于肯定的决策器。 用户持有一个同意访问的角色就能通过。
     * @return AffirmativeBased
     */
    @Bean
    public AffirmativeBased affirmativeBased(List<AccessDecisionVoter<?>> decisionVoters) {
        return new AffirmativeBased(decisionVoters);
    }

    @Bean
    public AccessDecisionVoter<Object> accessDecisionVoter() {
        return new RoleVoter();
    }

}
