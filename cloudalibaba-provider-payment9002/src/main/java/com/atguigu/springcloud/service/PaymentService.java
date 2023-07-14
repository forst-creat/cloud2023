package com.atguigu.springcloud.service;

/**
 * ClassName: PaymentService
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/7/14 - 9:00
 */
public interface PaymentService {

    /**
     * 集群nacos负载均衡测试
     * @param id
     * @return
     */
    String getPayment(Integer id);
}
