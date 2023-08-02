package com.example.marketing.service;

import com.example.marketing.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;

 @Service
public interface MarketingService {



    //Shows the Product on the page.
    Product DisplayProduct(Product product);

    //Applies a discount to the specific product.
    void DiscountPrice(Product product);



    // Provides a way to display all marketing stuff from ADMIN/Marketing
    void loadCatalog(Collection<Product> catalog);


    //Saves data to persistent.
    void gotomarketing();




}
