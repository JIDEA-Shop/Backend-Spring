package com.example.packing.service;

import com.example.packing.entity.Slot;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface packingService {




    //Load items onto shelf
    void shelfItem(Slot slot);

    //Notify customer if the item is empty or available and how much is present
    int shelfstatus(Slot slot);

    //Returns all Shelf contents
    Collection<Slot> shelfInfo();

    void processShipment();



}
