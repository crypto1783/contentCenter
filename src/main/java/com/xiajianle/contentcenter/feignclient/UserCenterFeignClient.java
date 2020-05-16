package com.xiajianle.contentcenter.feignclient;

import com.xiajianle.contentcenter.configuration.UserCenterFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.xiajianle.usercenter.domain.dto.UserDTO;

@FeignClient(name = "user-center", configuration = UserCenterFeignConfiguration.class)
public interface UserCenterFeignClient {
    /**
     * http://user-center/users/{id}
     *
     * @param id
     * @return
     */
    //@RequestMapping(value = "/users/{id}")
    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    UserDTO findById(@PathVariable("id") Integer id);
}

