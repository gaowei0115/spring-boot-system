package com.mmc.spring.boot.dubbo.api;

import com.mmc.spring.boot.dubbo.domain.OrderEntity;

import java.util.List;

/**
 * @packageName：com.mmc.spring.boot.dubbo.api
 * @desrciption: 模拟订单接口
 * @author: gaowei
 * @date： 2018-12-25 17:32
 * @history: (version) author date desc
 */
public interface IOrderService {

    /**
     * 查询所有订单信息
     * @return
     */
    List<OrderEntity> queryAllOrderInfo();
}
