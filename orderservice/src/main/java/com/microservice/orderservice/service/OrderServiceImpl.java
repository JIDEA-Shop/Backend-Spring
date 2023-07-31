package com.microservice.orderservice.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.orderservice.dto.OrderRequest;
import com.microservice.orderservice.entity.Order;
import com.microservice.orderservice.repository.OrderRepository;

@Service

public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        // TODO Auto-generated method stub;
        Order order =new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderItemsList(orderRequest.getOrderItems());
        order.setAddress(orderRequest.getAddress());
        order.setUserId(orderRequest.getUserId());
        
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);
        order.setDate(date);

        order.setTime(Time.valueOf(LocalTime.now()));

        double totalPrice =orderRequest.getOrderItems().stream().map(x -> (x.getPrice() * x.getQuantity())).reduce(0.0, (a,b)->a+b);
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order getOrdersById(int id){
       return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> getOrdersByUserId(int userId){
        List<Order> list = orderRepository.findAll(); 
        return list.stream().filter(x -> (x.getUserId()==userId)).toList();
    }

}
