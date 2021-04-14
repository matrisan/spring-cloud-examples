package com.github.spring.cloud.user.center.controller;

import com.github.spring.boot.common.framework.ResultVO;
import com.github.spring.cloud.user.center.pojo.vo.ISystemUserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TODO
 * <p>
 * create in 2021/4/14 6:56 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserManagerController {

    ResultVO<Page<ISystemUserVO>> findAllUsers(Pageable pageable);

}
