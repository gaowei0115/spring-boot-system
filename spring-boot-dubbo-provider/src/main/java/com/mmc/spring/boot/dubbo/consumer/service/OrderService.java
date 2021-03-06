package com.mmc.spring.boot.dubbo.consumer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mmc.spring.boot.dubbo.api.IOrderService;
import com.mmc.spring.boot.dubbo.consumer.dao.OrderDao;
import com.mmc.spring.boot.dubbo.domain.OrderEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @packageName：com.mmc.spring.boot.dubbo.consumer.service
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-25 17:33
 * @history: (version) author date desc
 */
@Service(interfaceClass = IOrderService.class, version = "1.0")
@Component
public class OrderService implements IOrderService{

    @Autowired
    private OrderDao orderDao;

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);


    @Override
    public List<OrderEntity> queryAllOrderInfo() {
        log.debug("获取订单信息....");
        System.out.println("获取订单信息....");
        return orderDao.queryOrderInfos();
    }
}
