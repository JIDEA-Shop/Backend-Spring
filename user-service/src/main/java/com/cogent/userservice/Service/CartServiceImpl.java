package com.cogent.userservice.Service;

import com.cogent.userservice.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CartServiceImpl {
    private Set<CartItem> Cart = new HashSet<>();
    private Set<CartItem> WishList = new HashSet<>();


}
