package com.example.shopping.service;


import com.example.shopping.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface shoppingService {



    // Put single product into Basket
    void putintoCart(Product product );


    // Put N products into Basket.
    void putNintoCart(Product product);


        /*
    {
    "sku": ""
    }
     */
        // Save Product to wishlist.
    void savetoWishlist(Product product);


    /*
    {
    "sku": ""
    }
     */

    // Pull Product out of basket.
    void PulloutCart(Product product);

    // Pull N Product out of basket.
    void PulloutNCart(Product product);

    // Display all Product.
    List<Product> showall();


    void checkout();



}
