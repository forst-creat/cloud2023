package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * ClassName: PaymentController
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/7/1 - 7:01
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentZk() {
        return "springcloud with zookeeper：" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
