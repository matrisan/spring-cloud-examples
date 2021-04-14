package com.github.spring.cloud.open.feign.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 * <p>
 * create in 2021/3/18 3:24 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FeignClient("name")
public interface IRemoteService {

    @GetMapping("/12345")
    String getData();

}
