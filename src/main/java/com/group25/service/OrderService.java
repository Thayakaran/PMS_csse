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

    public Collection<OrderDetail> getOrderDetails(String constructorID, String managerID, String supplierID ,String status, String from, String to){
        return this.orderDao.getOrderDetails(constructorID, managerID, supplierID, status, from, to);
    }
    public String updateStatus(String orderID, String status){
        return this.orderDao.updateOrderStatus(orderID, status);
    }
    public String addOrder(int orderedBy, String item, int manager, String site, double quantity, String description, int contactNo, Date requiredDate, String note){
        return this.orderDao.addOrder(orderedBy, item, manager, site, quantity, description, contactNo, requiredDate, note);
    }
    public String updateOrder(int orderID, int orderedBy, String item, int manager, String site, double quantity, String description, int contactNo, Date requiredDate, String note){
        return this.orderDao.updateOrder(orderID, orderedBy, item, manager, site, quantity, description, contactNo, requiredDate, note);
    }
}
