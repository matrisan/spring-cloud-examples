package com.github.spring.cloud.user.center.constraint.validator;

import com.github.spring.cloud.user.center.constraint.NewUsername;
import com.github.spring.cloud.user.center.domain.repository.ISystemUserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * TODO
 * <p>
 * create in 2021/4/14 10:30 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class NewUsernameValidator implements ConstraintValidator<NewUsername, String> {

    @Resource
    private ISystemUserRepository repository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !repository.existsByUsernameEquals(value);
    }
}
