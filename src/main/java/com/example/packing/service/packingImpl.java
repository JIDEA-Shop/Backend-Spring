package com.example.packing.service;

import com.example.packing.entity.Shelf;
import com.example.packing.entity.Slot;
import com.example.packing.repository.packingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class packingImpl implements packingService {


    private Shelf shelf= new Shelf();

    private packingRepository packingrepo;

    public packingImpl(@Autowired packingRepository packingrepo){

        this.packingrepo = packingrepo;


    }



    // The inventory from the warehouse enters the shelving at the store.
    @Override
    public void shelfItem(Slot slot) {

        shelf.increaseStock(slot);


    }


    // Return Amount on the item.
    @Override
    public int shelfstatus(Slot slot) {


        return shelf.getAmount(slot);


    }



    // Return the entire Shelf
    @Override
    public Collection<Slot> shelfInfo() {

        return shelf.getShelf();

    }

    @Override
    public void processShipment() {

        packingrepo.saveAll(shelf.getShelf());


    }


}
