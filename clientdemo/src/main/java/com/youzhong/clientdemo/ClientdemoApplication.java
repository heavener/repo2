package com.youzhong.clientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients //Feign中已经自动集成了Ribbon负载均衡，因此我们不需要自己定义RestTemplate了
public class ClientdemoApplication {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return restTemplateBuilder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientdemoApplication.class, args);
    }

}
