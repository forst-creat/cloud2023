package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: PaymentService
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/6/11 - 16:16
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
