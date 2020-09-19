package com.youzhong.clientdemo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.youzhong.clientdemo.bean.User;
import com.youzhong.clientdemo.bean.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("/getUser")
    // 使用HystrixCommand注解，在fallbackMethod属性中指定fallback的方法
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User getUser() {
        return this.userFeignClient.getUserById(1);

//        String providerName ="user-service-provider";
//            long begin = System.currentTimeMillis();
//            List<ServiceInstance> instances = discoveryClient.getInstances(providerName);
//            System.out.println(instances.get(0).getPort());
//            restTemplate.getForObject("http://"+providerName+"/user/"+1, User.class);
//            long end = System.currentTimeMillis();
//            // 记录访问用时：
//            System.out.println("访问用时：{}"+(end - begin));

//        for(int i=0;i<10;i++){
//            long begin = System.currentTimeMillis();
//            List<ServiceInstance> instances = discoveryClient.getInstances(providerName);
//            System.out.println(instances.get(0).getPort());
//            restTemplate.getForObject("http://"+providerName+"/user/"+1, User.class);
//            long end = System.currentTimeMillis();
//            // 记录访问用时：
//            System.out.println("访问用时：{}"+(end - begin));
//        }

    }

    public User findByIdFallback() {
        User user = new User();
        user.setId(1);
        user.setName("用户信息查询出现异常！");
        return user;
    }
}
