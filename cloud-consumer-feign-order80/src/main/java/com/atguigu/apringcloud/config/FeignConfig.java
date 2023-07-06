package com.atguigu.apringcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: FeignConfig
 * Description:
 *
 * @Author: liuyang
 * @Create: 2023/7/6 - 22:18
 */
@Configuration
public class FeignConfig {

    /**
     * 配置openfeign中的不同日志等级
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
