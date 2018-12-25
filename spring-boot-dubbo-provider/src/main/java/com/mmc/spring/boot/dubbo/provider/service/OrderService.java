package com.mmc.spring.boot.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mmc.spring.boot.dubbo.api.IOrderService;
import com.mmc.spring.boot.dubbo.provider.dao.OrderDao;
import com.mmc.spring.boot.dubbo.domain.OrderEntity;
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

    @Override
    public List<OrderEntity> queryAllOrderInfo() {
        return orderDao.queryOrderInfos();
    }
}
