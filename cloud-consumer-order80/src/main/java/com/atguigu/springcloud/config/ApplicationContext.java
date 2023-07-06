package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ApplicationContext
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/6/11 - 22:16
 */
@Configuration
public class ApplicationContext {

    @Bean
    //去除Rabbion中@LoadBalanced注解，用自己实现的负载均衡之轮询机制
    //@LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
