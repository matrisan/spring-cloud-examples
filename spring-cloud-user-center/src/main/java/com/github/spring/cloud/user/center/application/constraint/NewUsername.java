package com.github.spring.cloud.user.center.constraint;

import com.github.spring.cloud.user.center.constraint.validator.NewUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 * <p>
 * create in 2021/4/14 10:30 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = NewUsernameValidator.class)
public @interface NewUsername {

    String value() default "";

    String message() default "密码不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
