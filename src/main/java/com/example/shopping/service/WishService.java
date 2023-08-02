package com.example.shopping.service;

import com.example.shopping.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import com.example.shopping.entity.Wish;

@Service
public interface WishService {

    /*
{
"sku": ""
}
*/
    // Save Product to wishlist.
    void savetoWishlist(Product product);


    // Display all Wishlist
    Collection<Wish> getEntireWishlist();


    // Search in Wishlist and remove.
    void removeFromWishlist(Product product);



}
