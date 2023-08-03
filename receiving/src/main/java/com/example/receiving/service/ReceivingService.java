package com.example.receiving.service;

import com.example.receiving.entity.Inventoryitem;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ReceivingService {



    // Loads the Amount of the new Product to Storage.
    void unloadTruck(Inventoryitem item);

    // Displays all inventory.
    Collection<Inventoryitem> inventoryCheck();

    // Removes from inventory and sends status
    void pickandPack(Inventoryitem inventoryitem);

    void warehouseStore();



    //TODO: Inside the implementation I need to do a "sync" command to have the cache update with the database.



}
