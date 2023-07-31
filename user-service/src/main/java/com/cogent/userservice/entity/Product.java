package com.cogent.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Stub for Product
 */
@Data
@Entity
@Table
public class Product {
    /**
     * TODO: Change Product to be a Stub for future Product Service Openfeign
     */
    @Id
    @Column(name = "id")
    private Long product;
    @Column(name = "name")
    private String productName;
    @Column(name = "price")
    private BigDecimal unitPrice;
    @Column(name = "unit-in-stock")
    private Long unitsInStock;
    @OneToOne
    private CartItem cartItem;


}
