package com.example.shopping.controller;

import com.example.shopping.entity.Product;
import com.example.shopping.service.shoppingService;
import com.example.shopping.service.shoppingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class shoppingcontroller implements shoppingService {


    shoppingServiceImpl shoppingservice;

    public shoppingcontroller(@Autowired shoppingServiceImpl shoppingservice){
        this.shoppingservice = shoppingservice;

    }



    @Override
    @PostMapping("/api/shopping/place")
    public void putintoCart(@RequestBody Product product){

        shoppingservice.putintoCart(product);

    }

    @Override
    @PostMapping("/api/shopping/Nplace")
    public void putNintoCart(@RequestBody Product product){
        shoppingservice.putNintoCart(product);


    }

    @Override
    @PostMapping(path = "/api/shopping/wish")
    public void savetoWishlist(@RequestBody Product product) {

        shoppingservice.savetoWishlist(product);

    }


    @PostMapping("/api/shopping/Swishlist")
    void savetoWishlist(@RequestBody String sku){

        //todo

    }



    //Remove by sku:

    /*

    {
        "sku" : ""
    }

     */
    @PostMapping(path="/api/shopping/remove")
    public void PulloutCart(@RequestBody Product product){

        shoppingservice.PulloutCart(product);

    }

    /*
 {
 "N":     ,
 "sku": "",
 }
 */
    @Override
    @PostMapping(path = "/api/shopping/Nremove")
    public void PulloutNCart(@RequestBody Product product) {

        shoppingservice.PulloutNCart(product);
    }


    @GetMapping("api/shopping/display")
    public List<Product> showall(){


        return shoppingservice.showall();
    }


    @PostMapping("/api/shopping/complete")
    public void checkout(){

        shoppingservice.checkout();


    }


}
