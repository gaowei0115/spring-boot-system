package com.mmc.spring.boot.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mmc.spring.boot.dubbo.api.IOrderService;
import com.mmc.spring.boot.dubbo.domain.OrderEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @packageName：com.mmc.spring.boot.dubbo.consumer.controller
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-25 17:38
 * @history: (version) author date desc
 */
@RestController
@RequestMapping("/o")
public class OrderController {

    @Reference(version = "1.0")
//    @Reference
    private IOrderService orderService;

    @RequestMapping("allOrders")
    public List<OrderEntity> queryOrders() {
        return orderService.queryAllOrderInfo();
    }
}
