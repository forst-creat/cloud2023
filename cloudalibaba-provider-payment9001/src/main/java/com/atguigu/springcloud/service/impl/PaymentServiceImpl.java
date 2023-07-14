package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * ClassName: PaymentServiceImpl
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/7/14 - 7:41
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getPayment(Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }
}
