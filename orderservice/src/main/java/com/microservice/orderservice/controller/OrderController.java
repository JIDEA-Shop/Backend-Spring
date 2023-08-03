package com.microservice.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.orderservice.dto.OrderRequest;
import com.microservice.orderservice.entity.Order;
import com.microservice.orderservice.entity.OrderItems;
import com.microservice.orderservice.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
        Order order =orderService.getOrdersById(id);
        
        return order;
    }

    @GetMapping("/user/{id}")
    public List<Order> getOrderByUserId(@PathVariable int id , @RequestBody OrderRequest order){
        return orderService.getOrdersByUserId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody OrderRequest orderRequest, @PathVariable int id){

        return orderService.updateOrder(orderRequest, id);
    }

    @GetMapping("/productList/{id}")
    public List<OrderItems> getOrdersItemList(@PathVariable String id){
        return orderService.getOrderItems(Integer.valueOf(id));
    }


}
