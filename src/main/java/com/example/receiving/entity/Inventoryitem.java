package com.example.receiving.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Inventoryitem {


    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Id
    int inventoryitemId;
    @Getter
    String sku;
    @Getter
    int n;

    public Inventoryitem(){}

    public Inventoryitem(String sku, int N){

        this.sku = sku ;
        this.n = N;

    }


}
