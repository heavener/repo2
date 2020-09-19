package com.youzhong.clientdemo.bean;

import org.springframework.stereotype.Component;

@Component
public class UserFeignFallBack {
//public class UserFeignFallBack implements UserFeignClient {

    //    @Override
    public User getUserById(int id) {
        User user = new User();
        user.setId(id);
        user.setName("用户服务查询出现异常");
        return user;
    }
}
