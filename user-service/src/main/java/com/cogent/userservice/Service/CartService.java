package com.cogent.userservice.Service;

import org.springframework.stereotype.Service;

@Service
public interface CartService {
    public void addToCart();

    public void addToWishList();

    public void removeFromCart();

    public void removeFromWishlist();
}
