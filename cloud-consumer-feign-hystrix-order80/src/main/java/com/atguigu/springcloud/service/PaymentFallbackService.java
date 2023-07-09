package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * ClassName: PaymentFallbackService
 * Description:服务降级解耦，未解耦前，需要在每个方法上添加@HystrixCommand注解及属性方法，解耦后加不加该注解无所谓
 *
 * @Author: liuyang
 * @Create: 2023/7/9 - 9:10
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }
}
