package com.mmc.spring.boot.dubbo.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @packageName：com.mmc.spring.boot.dubbo.provider
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-25 16:30
 * @history: (version) author date desc
 */

@ComponentScan("com.mmc.spring.boot.dubbo.provider")
@SpringBootApplication
@EnableDubboConfiguration
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
