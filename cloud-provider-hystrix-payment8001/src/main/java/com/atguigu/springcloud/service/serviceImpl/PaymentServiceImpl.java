package com.atguigu.springcloud.service.serviceImpl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //=========服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {  //name属性的值从HystrixCommandProperties中找
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间长窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }
}
