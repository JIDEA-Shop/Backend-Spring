package com.microservice.orderservice.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.orderservice.dto.OrderRequest;
import com.microservice.orderservice.entity.Order;
import com.microservice.orderservice.entity.OrderItems;
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
    public ResponseEntity<Order> updateOrder(OrderRequest orderRequest,int id) {
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent()) 
            return ResponseEntity.of(order);
        
        
        Order existingOrder = orderRepository.getReferenceById(id);
        existingOrder.setAddress(orderRequest.getAddress());
        existingOrder.setOrderItemsList(orderRequest.getOrderItems());
        
        orderRepository.save(existingOrder);
    

        return ResponseEntity.ok(existingOrder);
    }

    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        // TODO Auto-generated method stub;
        Order order =new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderItemsList(orderRequest.getOrderItems());
        order.setAddress(orderRequest.getAddress());
        order.setOrderEmail(orderRequest.getUserEmail());
        
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
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent())return null;
        return order.get();
    }

//    @Override
//    public List<Order> getOrdersByUserId(int userId){
//        List<Order> list = orderRepository.findAll();
//        return list.stream().filter(x -> (x.getUserId()==userId)).toList();
//    }

    @Override
    public List<OrderItems> getOrderItems(int id) {
        // TODO Auto-generated method stub
       Optional<Order> order = orderRepository.findById(id);
        return order.get().getOrderItemsList();
    }

    
   

}
