package com.example.shopping.repository;

import com.example.shopping.entity.Product;
import com.example.shopping.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wish, Integer> {
}
