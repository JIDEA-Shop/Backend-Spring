package com.cogent.userservice.dao;

import com.cogent.userservice.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cart",path = "cart")
public interface CartItemDao extends JpaRepository<CartItem,Long> {
}
