package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * ClassName: LoadBalancer
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/7/6 - 1:23
 */
public interface LoadBalancer {
    //参数为集群中的服务器总数；获取当前调用的具体服务提供者
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
