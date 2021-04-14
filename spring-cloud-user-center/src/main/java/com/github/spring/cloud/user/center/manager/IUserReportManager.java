package com.github.spring.cloud.user.center.manager;

import com.github.spring.boot.common.user.report.UserDailyReportDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 * <p>
 * create in 2021/4/2 4:23 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FeignClient("name")
public interface IUserReportManager {

    @GetMapping("/")
    UserDailyReportDTO getDailyReport();

}
