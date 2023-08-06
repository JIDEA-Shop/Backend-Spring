package com.example.receiving.controller;

import com.example.receiving.entity.Inventoryitem;
import com.example.receiving.service.ReceivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
public class Receivingcontroller implements ReceivingService {


    ReceivingService receivingService;

    public Receivingcontroller(@Autowired ReceivingService receivingService){

        this.receivingService = receivingService;

    }




    /*

    {
    "sku" :     "",
    "n"   :
    }

     */

    @Override
    @PostMapping("/api/receiving/unload")
    public void unloadTruck(@RequestBody Inventoryitem inventoryitem) {

        receivingService.unloadTruck(inventoryitem);

    }

    @Override
    @GetMapping("/api/receiving/check")
    public Collection<Inventoryitem> inventoryCheck() {

      return receivingService.inventoryCheck();


    }


/*

    {
    "sku" :     "",
    "n"   :
    }

     */
    @Override
    @PostMapping("/api/receiving/pull")
    public void pickandPack(@RequestBody Inventoryitem inventoryitem ) {

        receivingService.pickandPack(inventoryitem);


    }

    @Override
    @PostMapping("/api/receiving/coldstore")
    public void warehouseStore() {

        receivingService.warehouseStore();


    }
}
