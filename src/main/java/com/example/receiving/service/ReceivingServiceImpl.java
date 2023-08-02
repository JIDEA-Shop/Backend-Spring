package com.example.receiving.service;

import com.example.receiving.entity.Box;
import com.example.receiving.entity.Inventoryitem;
import com.example.receiving.repository.ReceivingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReceivingServiceImpl implements ReceivingService {


    Box box = new Box();


    public ReceivingRepository receivingRepository;

    public ReceivingServiceImpl(@Autowired ReceivingRepository receivingRepository

                                ){

        this.receivingRepository = receivingRepository;
    }


    @Override
    public void UnloadTruck(Inventoryitem item) {

        box.updateItem(item);

    }

    @Override
    public Collection<Inventoryitem> InventoryCheck() {

        return box.displayAllItems();
    }

    @Override
    public void PickandPack(Inventoryitem inventoryitem) {

        box.prepareToShip(inventoryitem);


    }


    public void Sync(){

        receivingRepository.saveAll(box.getBox());

    }




}
