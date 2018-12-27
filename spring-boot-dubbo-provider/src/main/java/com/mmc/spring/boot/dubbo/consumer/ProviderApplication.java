package com.mmc.spring.boot.dubbo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @packageName：com.mmc.spring.boot.dubbo.provider
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-25 16:30
 * @history: (version) author date desc
 */
@SpringBootApplication
@EnableDubbo
public class ProviderApplication extends SpringBootServletInitializer{


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProviderApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
