package com.mmc.spring.boot.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mmc.spring.boot.dubbo.api.IHelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @packageName：com.mmc.spring.boot.dubbo.consumer.controller
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-25 16:42
 * @history: (version) author date desc
 */
@RestController
@RequestMapping("/i")
public class HelloController {


    @Reference
    private IHelloService helloService;

    @RequestMapping("sayHello")
    public String sayHello() {
        return helloService.sayHello("dubbo");
    }
}
