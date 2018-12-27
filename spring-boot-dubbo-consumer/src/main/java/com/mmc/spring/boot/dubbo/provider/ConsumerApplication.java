package com.mmc.spring.boot.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
@EnableAutoConfiguration
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
