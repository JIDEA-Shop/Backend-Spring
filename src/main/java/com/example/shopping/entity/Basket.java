package com.example.shopping.entity;

import java.util.LinkedList;

public class Basket {



    LinkedList<Product> basket = new LinkedList<>();


    // Stores item in the basket.
    public void storeItem(Product e) {

        this.basket.push(e);
    }


    // Removes item from the basket
    public void removeItem(Product product) {



        for(Product e : basket){

            if(e.getSku().equals(product.getSku())){

                System.out.println("Match Found removing");
                this.basket.remove(e);
            }
        }
    }

    //Searches inside basket to remove N amount of Product
    public void storeNItem(Product e) {

        for(int i = 0; i< e.getN() ; i++){
            storeItem(e);
        }

    }



    // Removes N items of with the SKU in basket.
    // If the N items is more than there are available, it will remove all items.
    public void removeNItem(Product product){

        int counter = product.getN();
        for(Product e : basket){

            if(product.getN() == 0){
                break;
            }

            if(e.getSku().equals(product.getSku())){

                basket.remove(e);
                counter--;
            }


        }

    }


    public LinkedList<Product> getBasket() {
        return basket;
    }

    public void setBasket(LinkedList<Product> basket) {
        this.basket = basket;
    }


}