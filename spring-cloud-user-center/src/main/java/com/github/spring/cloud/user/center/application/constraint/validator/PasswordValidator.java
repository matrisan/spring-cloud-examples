package com.github.spring.cloud.user.center.constraint.validator;


import com.github.spring.cloud.user.center.constraint.Password;
import com.github.spring.cloud.user.center.domain.repository.ISystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 石少东
 * @date 2020-06-16 17:41
 */
@Slf4j
@RequiredArgsConstructor
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private final PasswordEncoder encoder;

    private final ISystemUserRepository repository;

    @Override
    public boolean isValid(String rawPassword, ConstraintValidatorContext context) {
        String encodedPassword = repository.findCurrentPassword();
        boolean pass = encoder.matches(rawPassword, encodedPassword);
        log.debug("密码匹配结果:{}", pass);
        return pass;
    }

}
