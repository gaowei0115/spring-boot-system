package com.mmc.spring.boot.dubbo.domain;

import java.io.Serializable;

/**
 * @packageName：com.mmc.spring.boot.dubbo.domain
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-25 17:28
 * @history: (version) author date desc
 */
public class OrderEntity implements Serializable{

    private static final long serialVersionUID = -4773129694303655233L;

    private String orderId;
    private String orderName;
    private String orderType;

    private double orderMoney;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
    }
}
