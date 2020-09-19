package com.youzhong.clientdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;

@SpringBootTest
class ClientdemoApplicationTests {

    @Autowired
    private RibbonLoadBalancerClient balancerClient;

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            ServiceInstance instance = this.balancerClient.choose("user-service-provider");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }
    }

    @Test
    void contextLoads() {
    }


}
