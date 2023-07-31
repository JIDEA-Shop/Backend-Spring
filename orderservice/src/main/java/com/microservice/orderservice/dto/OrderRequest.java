package com.microservice.orderservice.dto;

import java.util.List;

import com.microservice.orderservice.entity.OrderItems;

public class OrderRequest {
    private List<OrderItems> orderItems;
    private String address;
    private int userId;

    public OrderRequest() {
    }

    public OrderRequest(List<OrderItems> orderItems, String address, int userId) {
        this.orderItems = orderItems;
        this.address = address;
        this.userId = userId;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
