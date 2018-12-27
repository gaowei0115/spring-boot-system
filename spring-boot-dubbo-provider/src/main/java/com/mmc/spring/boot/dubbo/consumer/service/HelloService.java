package com.mmc.spring.boot.dubbo.consumer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mmc.spring.boot.dubbo.api.IHelloService;
import org.springframework.stereotype.Component;

/**
 * @packageName：com.mmc.spring.boot.dubbo.provider.service
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-25 16:33
 * @history: (version) author date desc
 */
@Service(interfaceClass = IHelloService.class)
@Component
public class HelloService implements IHelloService{
    @Override
    public String sayHello(String param) {
        return param + " hello";
    }
}
