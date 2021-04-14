package com.github.spring.cloud.user.center.pojo.dto;


import com.github.spring.cloud.user.center.constraint.Password;
import com.github.spring.cloud.user.center.constraint.ResetPassword;
import lombok.Data;

/**
 * @author 石少东
 * @date 2020-06-16 17:16
 */

@Data
@ResetPassword
public class ResetPasswordDTO {

    @Password
    private String passwordOld;

    private String passwordNew1;

    private String passwordNew2;

}
