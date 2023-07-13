package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: SendMessageController
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/7/13 - 10:47
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessages")
    public String sendMessages() {
        return iMessageProvider.send();
    }
}
