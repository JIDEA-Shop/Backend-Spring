package com.microservice.orderservice.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="Orders")
public class Order {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String orderNumber;

    @OneToMany(cascade=CascadeType.ALL)
    private List<OrderItems> orderItemsList;

    private int userId;
    private Date date;
    private Time time;
    private Double totalPrice;
    private String address;

    public Order(){};
        
    public Order(String orderNumber, List<OrderItems> orderItemsList, int userId, Date date, Time time, Double totalPrice,
            String address) {
        this.orderNumber = orderNumber;
        this.orderItemsList = orderItemsList;
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.totalPrice = totalPrice;
        this.address = address;
    }




    public int getId() {
        return id;
    }
    public String getOrderNumber() {
        return orderNumber;
    }


    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }


    public void setOrderItemsList(List<OrderItems> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }


    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userid) {
        this.userId = userid;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
