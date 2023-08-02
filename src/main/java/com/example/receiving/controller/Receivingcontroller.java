package com.example.receiving.controller;

import com.example.receiving.entity.Inventoryitem;
import com.example.receiving.service.ReceivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class Receivingcontroller implements ReceivingService {


    ReceivingService receivingService;

    public Receivingcontroller(@Autowired ReceivingService receivingService){

        this.receivingService = receivingService;

    }




    @Override
    @PostMapping("/api/receiving/unload")
    public void UnloadTruck(@RequestBody Inventoryitem inventoryitem) {

        receivingService.UnloadTruck(inventoryitem);

    }

    @Override
    @GetMapping("/api/receiving/check")
    public Collection<Inventoryitem> InventoryCheck() {

      return receivingService.InventoryCheck();


    }



    @Override
    @PostMapping("/api/receiving/pull")
    public void PickandPack(@RequestBody Inventoryitem inventoryitem ) {

        receivingService.PickandPack(inventoryitem);


    }
}
