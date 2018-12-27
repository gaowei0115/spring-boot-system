package com.mmc.spring.boot.dubbo.consumer.dao;

import com.mmc.spring.boot.dubbo.domain.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.mmc.spring.boot.dubbo.consumer.dao
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-25 17:35
 * @history: (version) author date desc
 */
@Repository
public class OrderDao {

    public List<OrderEntity> queryOrderInfos() {
        List<OrderEntity> list = new ArrayList<>();
        OrderEntity order = new OrderEntity();
        order.setOrderId("001");
        order.setOrderName("phone-a01");
        order.setOrderType("01A");
        order.setOrderMoney(15000D);
        list.add(order);

        order = new OrderEntity();
        order.setOrderId("002");
        order.setOrderName("compute-b01");
        order.setOrderType("01B");
        order.setOrderMoney(25000D);
        list.add(order);

        return list;
    }
}
