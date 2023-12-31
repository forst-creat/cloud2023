package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ClassName: PaymentController
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/6/11 - 16:25
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入操作返回结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,服务端口号为：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}", payment);
        if (payment != null) {
            return new CommonResult<Payment>(200, "id为" + id + "的记录查询成功,服务端口号为：" + serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "id为" + id + "的记录查询失败", null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
