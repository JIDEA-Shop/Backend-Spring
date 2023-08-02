package com.example.shopping.service;

import com.example.shopping.entity.Basket;
import com.example.shopping.entity.Product;
import com.example.shopping.repository.shoppingRepository;
import com.example.shopping.shoppingServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class shoppingServiceImpl implements shoppingService{

    private shoppingRepository shoppingrep;


    //Here, basket is a local cache for the service.
    // A user will load the cache
    private Basket basket= new Basket();



    //This should be its own repository with Own Entities.
    private shoppingRepository wishrep;

    private Basket wishlist = new Basket();


    private shoppingServiceProxy proxy;

    public shoppingServiceImpl(@Autowired shoppingRepository shoppingrep
                              //, @Autowired shoppingServiceProxy proxy
                               ,@Autowired shoppingRepository wishingrep
                               ){
        this.shoppingrep = shoppingrep;
        this.wishrep= wishingrep;
      //  this.proxy = proxy;

    }




    @Override
    public void putintoCart(Product product) {

        basket.storeItem(product);


    }

    @Override
    public void putNintoCart(Product product) {

        basket.storeNItem(product);


    }

    @Override
    public void savetoWishlist(Product product) {

        wishlist.storeItem(product);


    }

    @Override
    public void PulloutCart(Product product) {

        System.out.println("Removing from cart");
        basket.removeItem(product);

    }

    @Override
    public void PulloutNCart(Product product) {

        basket.removeNItem(product);

    }


    @Override
    public List<Product> showall() {

        List<Product> li= new LinkedList<>();

        li = basket.getBasket();

        return li;

    }

    // Submits the Cache to the database.
    @Override
    public void checkout() {

        this.shoppingrep.saveAll(basket.getBasket());

    }
}
