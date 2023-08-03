package com.example.packing.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "slot")
public class Slot {



    //Slot is the entity.
    // |id|sku|ShelveAmount| Category


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int slotId;




    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setShelveamount(int shelveamount) {
        this.shelveamount = shelveamount;
    }

    @Getter
    String sku;

    @Getter
    String category;
    @Getter
    int shelveamount;



    public Slot(){}

    public Slot(String sku, int shelveamount){
        this.sku = sku;
        this.shelveamount = shelveamount;
    }










}
