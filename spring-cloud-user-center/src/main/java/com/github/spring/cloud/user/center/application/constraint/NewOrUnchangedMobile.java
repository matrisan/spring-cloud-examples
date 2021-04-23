package com.github.spring.cloud.user.center.constraint;

import com.github.spring.cloud.user.center.constraint.validator.NewOrUnchangedMobileValidator;

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
 * create in 2021/4/14 10:32 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = NewOrUnchangedMobileValidator.class)
public @interface NewOrUnchangedMobile {

    String value() default "";

    String message() default "密码不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
