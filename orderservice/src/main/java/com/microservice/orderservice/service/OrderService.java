package com.microservice.orderservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.orderservice.dto.OrderRequest;
import com.microservice.orderservice.entity.Order;
import com.microservice.orderservice.entity.OrderItems;

@Service
public interface OrderService{
    public Order placeOrder(OrderRequest orderRequest);
    public List<Order> getOrders();
    public Order  getOrdersById(int id);
//    public List<Order> getOrdersByUserId(int userId);
    public ResponseEntity<Order> updateOrder(OrderRequest orderRequest, int id);
    public List<OrderItems> getOrderItems(int orderId);
}
 