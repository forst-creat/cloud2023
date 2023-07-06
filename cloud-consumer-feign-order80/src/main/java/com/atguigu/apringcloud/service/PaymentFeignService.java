package com.atguigu.apringcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: PaymentFeignService
 * Description: 接口+Feign注解
 *
 * @Author: liuyang
 * @Create: 2023/7/6 - 21:32
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")  //服务端接口通过对应微服务名称去调用服务注册中心中对应微服务的对外暴露方法
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeOut();
}
