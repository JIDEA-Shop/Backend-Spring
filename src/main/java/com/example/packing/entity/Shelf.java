package com.example.packing.entity;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Shelf {

    // This class acts as a cache to interact with the
    // packing Service.



    /*

        This should probably be a set but this works for now.



     */



    /*

    Deep Comment:

    Earlier a long time back I ran into the issue of Using postmapping
    and getting null values.

    At first I thought it was a bad thing because it forced the Request Body
    to be very specific.

    However, In situations like this, You want null values.

    Why?

    Because if you do:

    {

    "sku" : "2gcv"

    }

    It will still pass through.

    you just get a class with sku value and null for everything else.

    The result is that every argument should be the POJO. it has everything you need


    Need to Test this out.

    CONCLUSION:

    YES THIS WORKS. Placed in Docs.



     */



    // Comment Two:
    /*

    Why do we have this service?

    Fundamentally, we want to keep the Entity as clean as possible.
    This is our POJO that maps to database.

    This class acts as a cache. We do this because the database is
    meant for persistent storage. We do not want to interact with the
    database beyond completing transactions.


     */



    Collection<Slot> shelf= new LinkedList<>();



    public Collection<Slot> getShelf(){

        return this.shelf;
    }





    // Returns the amount on the shelf now
    public int getAmount(Slot slot){


        System.out.println("RUNNING");
        System.out.println(slot.getSku());

        for(Slot e : shelf){


            System.out.println("IN THE LIST: " + e.getSku());

            if(e.getSku().equals(  slot.getSku()   )){

                System.out.println("THE AMOUNT: " + e.getShelveamount());
                // The stuff matches
                return e.getShelveamount();


            }

        }

        // If nothing shows up.
        return -9999;

    }





    //The input symbolizes the change the slot in absolute terms
    public void updateStock(Slot updatedSlot){

        for(Slot e : shelf){

            if(e.getSku().equals( updatedSlot.getSku()   )){

                e.setShelveamount(updatedSlot.getShelveamount());

            }


        }

    }

    // Increase Slot amount by delta N
    public int increaseStock(Slot deltaSlot){


        // This is a temporary hack. Should be own method....
        if(shelf.size() == 0){

            System.out.println("EMPTY SHELF. DOING NEW");
            shelf.add(deltaSlot);
            return deltaSlot.getShelveamount();

        }


        for(Slot e : shelf){

            if(e.getSku().equals( deltaSlot.getSku()   )){

                System.out.println("INCREASING DELTA");
                System.out.println("Delta "+ deltaSlot.getShelveamount() );
                System.out.println("current: " +  e.getShelveamount());

                // Here we increase it by delta.
                e.setShelveamount(  e.getShelveamount() +  deltaSlot.getShelveamount() );

                System.out.println("Update to: " + e.getShelveamount());

                return e.getShelveamount();

            }


        }


        //There is an error
        return -9999;


    }

    // Decrease Slot amount by delta N
    public void decreaseStock(Slot deltaSlot){

        for(Slot e : shelf){

            if(e.getSku().equals( deltaSlot.getSku()   )){


                // Here we increase it by delta.
                e.setShelveamount(  e.getShelveamount() -  deltaSlot.getShelveamount() );


                // OUT OF STOCK
                if(e.getShelveamount() < 0){

                    e.setShelveamount(0);

                }

            }


        }



    }

    // Remove Slot from Inventory
    public void removeSlot(String sku){

        for(Slot e: shelf){

            if(e.getSku().equals(sku)){

                shelf.remove(e);

            }

        }

    }

    public void modifysku(){

    }








}
