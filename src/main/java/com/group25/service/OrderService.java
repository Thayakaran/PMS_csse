package com.group25.service;

import com.group25.dao.OrderDao;
import com.group25.entity.Order;
import com.group25.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public Collection<OrderDetail> getOrderDetails(String constructorID, String managerID, String status, String from, String to){
        return this.orderDao.getOrderDetails(constructorID, managerID, status, from, to);
    }

    public String updateStatus(String orderID, String status){
        return this.orderDao.updateOrderStatus(orderID, status);
    }
}
