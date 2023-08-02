package com.example.marketing.entity;

import java.util.Collection;
import java.util.LinkedList;

public class Catalog {


    public Collection<Product> getCatalog() {
        return catalog;
    }

    public void setCatalog(Collection<Product> catalog) {
        this.catalog = catalog;
    }

    Collection<Product> catalog = new LinkedList<>();






    //This method returns the Entire Product information.
    // Should probably have alot of testing here to make
    // sure all content is present.
    public Product productDescription(Product product){

        Product error = new Product();
        //Nothing is in the catalog....
        if(catalog.size() == 0){


            System.out.println("EMPTY MARKETING MATERIAL");
            return error;

        }


        for(Product e : catalog ){

            if(e.getSku().equals( product.getSku()    )){

                return e;


            }

        }

        return error;
    }




    //This method provides how the discount is applied.
    // NOTE: we could apply alot of business logic later on.
    public void markdown(Product product){

        System.out.println("Marking Down Started");
        for(Product e : catalog){



            if(e.getSku().equals( product.getSku()   )){


                //Test to make sure you dont discount past zero
                if(e.getPrice() - product.getPrice() < 0){

                    System.out.println("WARNING. YOU ARE PAYING THE CUSTOMER NOW!!!");

                }else{

                    // Applying discount
                    e.setPrice( e.getPrice() - product.getPrice()  );

                }



            }

        }


    }



    // We need to determine whether this uploading
    // Is like a "publishing" where its the admins responsibility what is displayed.
    // Or that we do an "update"
    public void uploadCatalog(Collection<Product> newcatalog ){


        System.out.println("UPLOADING!!!!!!!!!!!!");
        System.out.println("Here, the dev would do stuff.");

        //Havent Tested Yet.
        catalog = newcatalog;


    }










}
