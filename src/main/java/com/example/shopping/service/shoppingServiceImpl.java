package com.example.shopping.service;

import com.example.shopping.entity.Basket;
import com.example.shopping.entity.Product;
import com.example.shopping.entity.Wish;
import com.example.shopping.repository.WishlistRepository;
import com.example.shopping.repository.shoppingRepository;
import com.example.shopping.shoppingServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class shoppingServiceImpl implements shoppingService, WishService{

    private shoppingRepository shoppingrep;


    //Here, basket is a local cache for the service.
    // A user will load the cache
    private Basket basket= new Basket();



    //This should be its own repository with Own Entities.
    private WishlistRepository wishrep;




   // private shoppingServiceProxy proxy;

    public shoppingServiceImpl(@Autowired shoppingRepository shoppingrep
                              //, @Autowired shoppingServiceProxy proxy
                               ,@Autowired WishlistRepository wishingrep
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

    // Save Product to Wish List.
    @Override
    public void savetoWishlist(Product product) {


        //Modify Product to Wish.
        Wish wish = new Wish();
        wish.setCost(product.getCost() );
        wish.setSku(product.getSku()   );


        wishrep.save(wish);


    }


    //Returns Entire Wishlist

    @Override
    public Collection<Wish> getEntireWishlist() {

        List<Wish> list = wishrep.findAll();

        HashSet<String> wishlistsku = new HashSet<>();
        for(Wish e : list){


            wishlistsku.add(e.getSku());

        }

        List<Wish> output = new LinkedList<>();

        for(String e : wishlistsku){

            Wish w = new Wish();

            w.setSku(e);

            output.add(w);

        }

        return output;
    }


    // Remove Product from Wishlist
    @Override
    public void removeFromWishlist(Product product) {

       // List<Wish> list = wishrep.findAll();


/*

        for(Wish e : list){

            if(e.getSku().equals( product.getSku() )){

                wishrep.delete(e);

            }

        }
*/


        wishrep.deleteAll();

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
