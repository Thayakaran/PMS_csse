package com.group25.controller;

import com.group25.entity.Order;
import com.group25.entity.OrderDetail;
import com.group25.entity.Site;
import com.group25.entity.User;
import com.group25.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addOrder(@RequestBody Order order){
        return orderService.addOrder(order.getOrderedBy(), order.getItem(), order.getManager(), order.getSite(), order.getQuantity(), order.getDescription(), order.getContactNo(), order.getRequiredDate(), order.getNote());
    }
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order.getId(), order.getOrderedBy(), order.getItem(), order.getManager(), order.getSite(), order.getQuantity(), order.getDescription(), order.getContactNo(), order.getRequiredDate(), order.getNote());
    }

    @RequestMapping(value = "/materials", method = RequestMethod.GET)
    public Collection<String> getMaterials(){
        return orderService.getMaterials();
    }

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public Collection<User> getManagers(){
        return orderService.getManagers();
    }
    @RequestMapping(value = "/sites", method = RequestMethod.GET)
    public Collection<Site> getSites(){
        return orderService.getSites();
    }
}
