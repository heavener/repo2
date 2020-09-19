package com.youzhong.clientdemo.bean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "user-service-provider", fallback = UserFeignFallBack.class,configuration = FeignConfig.class)
//@FeignClient(value = "user-service-provider",configuration = FeignConfig.class)
@FeignClient(value = "user-service-provider")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") int id);
}
