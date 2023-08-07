package com.project.ecommerce.springecommerce;

import com.project.ecommerce.springecommerce.dao.ProductRepository;
import com.project.ecommerce.springecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController("promos")
public class ResController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public void getPromo() {
        List<Product> promos = productRepository.findOldestUpdatedProducts();
        System.out.println(promos);
        for (Product promo: promos
             ) {
            productRepository.updateLastUpdated(promo.getId(),new Date(System.currentTimeMillis()));
        }
    }
}
