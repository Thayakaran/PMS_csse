package com.group25.service;

import com.group25.dao.OrderDao;
import com.group25.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public Collection<Order> getPendingOrder(int constructorID){
        return this.orderDao.getPendingOrder(constructorID);
    }

    public Order getOrderDetails(int orderID){
        return this.orderDao.getOrderDetails(orderID);
    }
}
