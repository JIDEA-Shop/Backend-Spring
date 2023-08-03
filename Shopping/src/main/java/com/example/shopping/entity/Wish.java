package com.example.shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="Wishes")
public class Wish {


    //Auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Getter
    String sku;

    @Getter
    int cost;


    public Wish(){}

    public Wish(String sku, int cost){
        this.sku = sku;
        this.cost = cost;
    }

}
