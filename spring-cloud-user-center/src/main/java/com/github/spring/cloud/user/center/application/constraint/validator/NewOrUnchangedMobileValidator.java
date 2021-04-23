package com.github.spring.cloud.user.center.constraint.validator;

import com.github.spring.cloud.user.center.constraint.NewOrUnchangedMobile;
import com.github.spring.cloud.user.center.domain.entity.SystemUserDO;
import com.github.spring.cloud.user.center.domain.repository.ISystemUserRepository;
import com.github.spring.cloud.user.center.interfaces.dto.SystemUserServiceDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/4/14 10:30 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class NewOrUnchangedMobileValidator implements ConstraintValidator<NewOrUnchangedMobile, SystemUserServiceDTO> {

    @Resource
    private ISystemUserRepository repository;

    @Override
    public boolean isValid(SystemUserServiceDTO value, ConstraintValidatorContext context) {
        Optional<SystemUserDO> optional = repository.findById(value.getId());
        if (optional.isPresent()) {
            SystemUserDO user = optional.get();
            if (StringUtils.equals(user.getMobile(), value.getMobile())) {
                return true;
            }
            return !repository.existsByMobile(value.getMobile());
        }
        return false;
    }
}
