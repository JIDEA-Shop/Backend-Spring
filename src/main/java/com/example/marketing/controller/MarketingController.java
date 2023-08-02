package com.example.marketing.controller;

import com.example.marketing.entity.Product;
import com.example.marketing.service.MarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class MarketingController implements MarketingService {


    MarketingService marketingService;




    public MarketingController(@Autowired MarketingService marketingService){

        this.marketingService = marketingService;
    }



    @GetMapping(path = "/api/marketing/showProduct")
    @Override
    public Product DisplayProduct(@RequestBody Product product) {

        return marketingService.DisplayProduct(product);



    }




    /*
    {

    "sku":  "",
    "price":

    }

     */
    @Override
    @PostMapping(path = "/api/marketing/discount")
    public void DiscountPrice(@RequestBody Product product) {

        marketingService.DisplayProduct(product);
    }

    @Override
    @PostMapping
    public void loadCatalog(@RequestBody Collection<Product> catalog) {

        marketingService.loadCatalog(catalog);


    }

}
