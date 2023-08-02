package com.example.receiving.entity;

import java.util.Collection;
import java.util.LinkedList;

public class Box {


    // This is the cache for the Entities


    public Collection<Inventoryitem> getBox() {
        return box;
    }

    public void setBox(Collection<Inventoryitem> box) {
        this.box = box;
    }

    private Collection<Inventoryitem> box = new LinkedList<>();




    public void updateItem(Inventoryitem inventoryitem){

        if(box.size() == 0){
            box.add(inventoryitem);
        }


        for(Inventoryitem i : box){

            if(i.getSku().equals( inventoryitem.getSku())){

                // Add new shipment to old one.
                i.setN( i.getN() + inventoryitem.getN() );

            }

        }

    }


    // This displays all contents
    public Collection<Inventoryitem> displayAllItems(){
        return getBox();
    }




    //This method updates the warehouse when the amount is pushed
    // to the shipping service
    public void prepareToShip(Inventoryitem inventoryitem){

        for(Inventoryitem i : box){

            if(i.getSku().equals(  inventoryitem.getSku()      )){


                if(i.getN() - inventoryitem.getN() < 0){

                    System.out.println("WARNING: NO ITEM WAREHOUSE. CONTACT ADMIN");

                }else {

                    // Update
                    i.setN(i.getN() - inventoryitem.getN());
                }
            }

        }


    }












}
