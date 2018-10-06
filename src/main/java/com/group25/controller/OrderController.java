package com.group25.controller;

import com.group25.entity.Order;
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

    @RequestMapping(value = "/{orderedBy}/status/{orderStatus}", method = RequestMethod.GET)
    public Collection<Order> getorders(@PathVariable("orderedBy") String constructorID, @PathVariable("orderStatus") String status){
        return orderService.getPendingOrder(constructorID);
    }

}
