package com.example.marketing.controller;

import com.example.marketing.entity.Product;
import com.example.marketing.service.MarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@CrossOrigin
@RestController
public class MarketingController implements MarketingService {


    MarketingService marketingService;




    public MarketingController(@Autowired MarketingService marketingService){

        this.marketingService = marketingService;
    }



  /*
    {

    "sku":  ""
    ,
    "price":

    }

     */
    @GetMapping(path = "/api/marketing/showProduct")
    @Override
    public Product DisplayProduct(@RequestBody Product product) {

        return marketingService.DisplayProduct(product);



    }

    @Override
    @GetMapping(path = "/api/marketing/display")
    public Collection<Product> DisplayCatalog() {
        return marketingService.DisplayCatalog();
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

        System.out.println("Dicount Query");
        marketingService.DiscountPrice(product);
    }



    /*

[
    {
    "sku": "alpha",
    "description": "the first greek letter",
    "imageURL": "IMAGE link goes here :)",
    "buyersChoice": true,
    "price": 25
    },
    {
    "sku": "beta",
    "description": "the second greek letter",
    "imageURL": "IMAGE link goes here :)",
    "buyersChoice": false,
    "price": 250
    }
]


     */

    @Override
    @PostMapping(path="/api/marketing/upload")
    public void loadCatalog(@RequestBody Collection<Product> catalog) {

        marketingService.loadCatalog(catalog);


    }



    @Override
    @GetMapping(path = "/api/marketing/catalog")
    public void DownloadCatalog() {

        marketingService.DownloadCatalog();


    }

    @Override
    @PostMapping(path="/api/marketing/analytics")
    public void gotomarketing() {

        marketingService.gotomarketing();
    }

}
