package com.cogent.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.SpringApplication;

import java.math.BigDecimal;

/**
 * Items used for cart and wishlist
 */
@Entity
@Table(name = "cart_item")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long cartId;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    @Column(name = "quantity")
    private Long itemQuantity;

    private BigDecimal subtotal;
}
