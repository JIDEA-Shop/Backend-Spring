package com.example.marketing.repository;

import com.example.marketing.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketingRepository extends JpaRepository<Product, Integer> {
}
