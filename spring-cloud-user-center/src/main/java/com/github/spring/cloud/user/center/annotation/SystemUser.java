package com.github.spring.cloud.user.center.annotation;

/**
 * @author 石少东
 * @date 2020-06-16 16:51
 */

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@AuthenticationPrincipal(expression = "@iSystemUserRepository.findById(#this.id)")
public @interface SystemUser {
}
