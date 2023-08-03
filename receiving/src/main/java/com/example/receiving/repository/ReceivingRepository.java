package com.example.receiving.repository;

import com.example.receiving.entity.Inventoryitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivingRepository extends JpaRepository<Inventoryitem, Integer> {


}
