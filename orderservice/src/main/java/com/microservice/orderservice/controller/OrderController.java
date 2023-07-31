package com.microservice.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.orderservice.dto.OrderRequest;
import com.microservice.orderservice.entity.Order;
import com.microservice.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    

    @GetMapping
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest order){
        return orderService.placeOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderService.getOrdersById(id);
    }

    @GetMapping("/user/{id}")
    public List<Order> getOrderByUserId(@PathVariable int id){
        return orderService.getOrdersByUserId(id);
    }


}
