package com.example.shopping.controller;

import com.example.shopping.entity.Product;
import com.example.shopping.entity.Wish;
import com.example.shopping.service.WishService;
import com.example.shopping.service.shoppingService;
import com.example.shopping.service.shoppingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class shoppingcontroller implements shoppingService , WishService {


    shoppingServiceImpl shoppingservice;

    public shoppingcontroller(@Autowired shoppingServiceImpl shoppingservice){
        this.shoppingservice = shoppingservice;

    }


/*
    {
            "sku" : 2425,
            "cost" : 110000
    }
*/

    @Override
    @PostMapping("/api/shopping/place")
    public void putintoCart(@RequestBody Product product){

        shoppingservice.putintoCart(product);

    }


    /*
    {
            "sku" : 2425,
            "cost" : 110000,
            "n" : 10
    }
*/

    // Insert N items into the shopping cart.
    @Override
    @PostMapping("/api/shopping/Nplace")
    public void putNintoCart(@RequestBody Product product){
        shoppingservice.putNintoCart(product);


    }


    /*

    {
        "sku" : ""
    }

     */
    //Remove item from cart by sku:
    @PostMapping(path="/api/shopping/remove")
    public void PulloutCart(@RequestBody Product product){

        shoppingservice.PulloutCart(product);

    }

    /*
 {
 "n":     ,
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



    /*
        {
                "sku" : 2425,
                "cost" : 110000
        }

        */
    @Override
    @PostMapping(path = "/api/shopping/wish")
    public void savetoWishlist(@RequestBody Product product) {

        shoppingservice.savetoWishlist(product);

    }


    //Grab the Entire Wishlist.
    @Override
    @GetMapping(path = "/api/shopping/wishlist")
    public Collection<Wish> getEntireWishlist() {
        return shoppingservice.getEntireWishlist();
    }


    /*
        {
                "sku" : 2425
        }

        */
    @Override
    @PostMapping(path = "/api/shopping/removewish")
    public void removeFromWishlist(@RequestBody Product product) {

        shoppingservice.removeFromWishlist(product);


    }



}
