package com.example.packing.controller;

import com.example.packing.entity.Slot;
import com.example.packing.service.packingImpl;
import com.example.packing.service.packingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class packingController implements packingService {


    private packingService packing;


    public packingController(@Autowired packingImpl packing) {
        this.packing = packing;
    }





    //SampleBody:
    /*
{
    "slotId" : ""   ,
    "sku" : ""      ,
    "category" :  ""  ,
    "shelveamount":

}
    */
    @Override
    @PostMapping(path = "/api/packing/new")
    public void shelfItem(@RequestBody Slot slot) {

        packing.shelfItem(slot);


    }



    // Sample Body:
    /*

{
    "sku": "abc"
}

    */
    @Override
    @GetMapping(path = "/api/packing/status")
    public int shelfstatus(@RequestBody Slot slot) {


        return packing.shelfstatus(slot);


    }


    @Override
    @GetMapping(path= "/api/packing/summary")
    public Collection<Slot> shelfInfo() {
        return packing.shelfInfo();
    }



    @Override
    @PostMapping(path = "/api/packing/ship")
    public void processShipment() {

        packing.processShipment();

    }


}
