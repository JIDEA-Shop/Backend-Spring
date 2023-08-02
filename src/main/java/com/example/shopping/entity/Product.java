package com.example.shopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;

@Entity
public class Product {


    //Product is the entity.
    // |id|sku|cost|





    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }



    public Product() {

    }

    public Product(String sku , int cost){

        this.sku = sku;
        this.cost = cost;

    }

    @Id
    private int id;

    String sku;

    int cost;

    public void setN(int n) {
        N = n;
    }

    @Getter
    @Transient
    int N;


}
