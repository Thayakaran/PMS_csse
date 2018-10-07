package com.group25.controller;

import com.group25.entity.Order;
import com.group25.entity.OrderDetail;
import com.group25.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/orders")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{orderedBy}/{manager}/{orderStatus}/{from}/{to}", method = RequestMethod.GET)
    public Collection<OrderDetail> getOrders(@PathVariable("orderedBy") String constructorID, @PathVariable("manager") String managerID, @PathVariable("orderStatus") String status, @PathVariable("from") String from, @PathVariable("to") String to){
        return orderService.getOrderDetails(constructorID, managerID, status, from, to);
    }

}
