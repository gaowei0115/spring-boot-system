package com.mmc.spring.boot.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
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
@SpringBootApplication
@ComponentScan("com.mmc.spring.boot.dubbo.provider")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
