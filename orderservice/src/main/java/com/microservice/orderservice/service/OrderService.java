package com.microservice.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.orderservice.dto.OrderRequest;
import com.microservice.orderservice.entity.Order;

@Service
public interface OrderService{
    public Order placeOrder(OrderRequest order);
    public List<Order> getOrders();
    public Order  getOrdersById(int id);
    public List<Order> getOrdersByUserId(int userId);
}
 