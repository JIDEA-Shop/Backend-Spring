package com.project.ecommerce.springecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="sku")
    private String sku;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="unit_price")
    private BigDecimal unit_price;

    @Column(name="image_url")
    private String image_url;

    @Column(name="active")
    private boolean active;

    @Column(name="units_in_stock")
    private int unitsInStock;

    @Column(name="date_created")
    @CreationTimestamp
    private Date date_created;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Date last_updated;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "product_category_middle",
//            joinColumns = {@JoinColumn(name = "product", nullable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "category_id", nullable = false)}
//    )
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
}
