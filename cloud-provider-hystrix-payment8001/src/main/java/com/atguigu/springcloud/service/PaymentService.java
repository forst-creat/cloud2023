package com.atguigu.springcloud.service;

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
}
