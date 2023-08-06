package com.microservice.orderservice.dto;

import java.util.List;

import com.microservice.orderservice.entity.OrderItems;

public class OrderRequest {
    private List<OrderItems> orderItems;
    private String address;
    private int userId;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private String userEmail;

    public OrderRequest() {
    }

    public OrderRequest(List<OrderItems> orderItems, String address,String userEmail) {
        this.orderItems = orderItems;
        this.address = address;
        this.userEmail = userEmail;
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
