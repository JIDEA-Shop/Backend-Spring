package com.example.packing.repository;

import com.example.packing.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface packingRepository extends JpaRepository<Slot , Integer> {
}
