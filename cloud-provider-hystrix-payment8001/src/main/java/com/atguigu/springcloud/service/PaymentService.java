package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: PaymentService
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/7/7 - 12:18
 */
public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    /**
     * 服务熔断
     * @param id
     * @return
     */
    public String paymentCircuitBreaker(Integer id);
}
