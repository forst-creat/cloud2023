package com.atguigu.springcloud.service.serviceImpl;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: PaymentServiceImpl
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/7/7 - 12:19
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK,id：" + id;
    }

    /**
     * 超时访问，演示降级
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String paymentInfo_TimeOut(Integer id) {
        int time = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int age = 10 / 0;
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id：" + id + "耗费时间：（秒）" + time + "\t" + "O(∩_∩)O哈哈~";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler，系统繁忙或运行错误，请稍后再试，id：" + id + "\t" + "o(╥﹏╥)o";
    }
}
