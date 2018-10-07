package com.group25.controller;

import com.group25.entity.Order;
import com.group25.entity.OrderDetail;
import com.group25.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orders")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{orderedBy}/{manager}/{supplierID}/{orderStatus}/{from}/{to}", method = RequestMethod.GET)
    public Collection<OrderDetail> getOrders(@PathVariable("orderedBy") String constructorID, @PathVariable("manager") String managerID, @PathVariable("supplierID") String supplierID, @PathVariable("orderStatus") String status, @PathVariable("from") String from, @PathVariable("to") String to){
        return orderService.getOrderDetails(constructorID, managerID, supplierID, status, from, to);
    }

    @RequestMapping(value = "/status", method = RequestMethod.PUT)
    public String updateStatus(@RequestBody Order order){
        return orderService.updateStatus(Integer.toString(order.getId()), order.getStatus());
    }

}
