package com.example.receiving.service;

import com.example.receiving.entity.Box;
import com.example.receiving.entity.Inventoryitem;
import com.example.receiving.repository.ReceivingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.SysexMessage;
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
    public void unloadTruck(Inventoryitem item) {

        box.updateItem(item);

    }

    @Override
    public Collection<Inventoryitem> inventoryCheck() {

        return box.displayAllItems();
    }

    @Override
    public void pickandPack(Inventoryitem inventoryitem) {

        box.prepareToShip(inventoryitem);


    }


    @Override
    public void warehouseStore (){

        for(Inventoryitem i : box.getBox()){
            System.out.println(i.getSku());
        }


        receivingRepository.saveAll(box.getBox());

    }




}
