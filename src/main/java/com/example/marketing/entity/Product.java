package com.example.marketing.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="DisplayCase")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int productId;

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setBuyersChoice(boolean buyersChoice) {
        this.buyersChoice = buyersChoice;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Getter
    String sku = "####ERROR######";
    @Getter
    String description = "NEED TO CONTACT ADMIN. ERROR";


    @Getter
    String name = "EMPTYERROR";

    @Getter
    @Column(length = 3000)
    String imageURL = "IMAGE ERROR. Did you get the right value?";

    @Getter
    boolean buyersChoice = false;

    @Getter
    int price = -9999;


    public Product(){}

    public Product(String sku ,
                   String name,
                   String description ,
                   String imageURL ,
                   boolean buyersChoice,
                   int price){

        this.sku = sku;
        this.name = name;
        this.description= description;
        this.imageURL = imageURL;
        this.buyersChoice = buyersChoice;
        this.price = price;


    }



}
