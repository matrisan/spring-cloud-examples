package com.github.spring.cloud.user.center.constraint.validator;


import com.github.spring.cloud.user.center.constraint.ResetPassword;
import com.github.spring.cloud.user.center.interfaces.dto.ResetPasswordDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 石少东
 * @date 2020-06-16 17:41
 */
@Slf4j
@RequiredArgsConstructor
public class ResetPasswordValidator implements ConstraintValidator<ResetPassword, ResetPasswordDTO> {

    @Override
    public boolean isValid(@NotNull ResetPasswordDTO value, ConstraintValidatorContext context) {
        boolean pass = StringUtils.equals(value.getPasswordNew1(), value.getPasswordNew2());
        log.debug("重置密码,新密码二次确认是否相同:{}", pass);
        return pass;
    }

}
