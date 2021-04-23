package com.github.spring.cloud.user.center.application.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.github.spring.cloud.user.center.infrastructure.common.SecurityConstant.PERMIT_ALL;
import static com.github.spring.cloud.user.center.infrastructure.common.SecurityConstant.SYSTEM_LOGIN_LOGOUT;
import static com.github.spring.cloud.user.center.infrastructure.common.SecurityConstant.SYSTEM_LOGIN_USERNAME;

/**
 * <p>
 * 创建时间为 下午8:34 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfigurerAdapterConfig extends WebSecurityConfigurerAdapter {

//    private final LogoutSuccessHandler logoutSuccessHandler;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;
//
//    private final AuthenticationFailureHandler failureHandler;
//
//    private final AuthenticationSuccessHandler successHandler;
//
////    private final InvalidSessionStrategyImpl sessionInvalidStrategy;
//
//    private final SessionInformationExpiredStrategyImpl sessionExpiredStrategy;
//
//    private final AuthenticationEntryPoint unauthorizedEntryPoint;
//
//    private final AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(@NotNull AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(@NotNull HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers(PERMIT_ALL).permitAll().anyRequest().authenticated();
        http.formLogin().loginProcessingUrl(SYSTEM_LOGIN_USERNAME).permitAll();
        http.logout().logoutUrl(SYSTEM_LOGIN_LOGOUT).permitAll();

        http.httpBasic().disable();
        http.csrf().disable();

//        // 自定义的登录接口,使用表单登录
//        // 自定义登录/登出url，自定义登录成功/失败处理器
//        http.formLogin().loginProcessingUrl("/login")
////                .successHandler(successHandler)
////                .failureHandler(failureHandler)
//                .and()
//                .logout().logoutUrl(SecurityConstant.SYSTEM_LOGIN_LOGOUT)
////                .logoutSuccessHandler()
////                .permitAll()
//        ;
//        http.authorizeRequests()
//
//                .antMatcher(SYSTEM_LOGIN_USERNAME)
//                .and().antMatcher(SYSTEM_LOGIN_USERNAME);
//        // 对 Session 的管理
//        http.sessionManagement()
//                // 登录超时处理
//                // .invalidSessionStrategy(sessionInvalidStrategy)
//                .maximumSessions(2)
//                .maxSessionsPreventsLogin(false)
//        // 异地登录处理
////                .expiredSessionStrategy(sessionExpiredStrategy)
//        ;
//
////        http.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint).accessDeniedHandler(accessDeniedHandler);
//
//        http.csrf().disable();
////        http.csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository());
////        http.apply(smsCodeAuthenticationSecurityConfig);
    }

    @Override
    @SneakyThrows(Exception.class)
    public void configure(@NotNull WebSecurity web) {
        web.ignoring().antMatchers("/");
        web.ignoring().antMatchers("/login");
        web.ignoring().antMatchers(SYSTEM_LOGIN_USERNAME);

        web.ignoring().antMatchers("/static/js/**");
        web.ignoring().antMatchers("/static/css/**");
        web.ignoring().antMatchers("/static/image/**");
    }

}
