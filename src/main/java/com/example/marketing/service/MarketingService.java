package com.example.marketing.service;

import com.example.marketing.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;

 @Service
public interface MarketingService {

/*

    The Marketing Service is responsible for managing information
    about Products. When shopping, Products describe the information
    to the end user. A user will read information from the Marketing
    Service and make decisions on where to shop.

    The Admin must have a catalog.csv as a single source of truth
    that the customer will read from the web page when shopping. The
    admin may apply discounts (DiscountPrice) to products as the
    service is running. If the admin wishes to preserve these
    discounts for further analysis, the may save it for marketing
    (gotomarketing)

    In the event that there is a mistake in the product catalog,
    the Admin may restart the service or load an emergency Catalog
    (loadCatalog).


This is the link to the catalog
https://docs.google.com/spreadsheets/d/1OGKu9ih20IVbhd8FHD8H7dKnFBJA7ehFjPqmatzkx3A/edit?usp=sharing

 */




    //Shows the Product on the page.
    Product DisplayProduct(Product product);

    Collection<Product> DisplayCatalog();

    //Applies a discount to the specific product.
    void DiscountPrice(Product product);



    // Provides a way to display all marketing stuff from ADMIN/Marketing
    void loadCatalog(Collection<Product> catalog);


    // Retrieves Data from Admin's S3 Bucket.
     void DownloadCatalog();



    //Saves data to persistent.
    void gotomarketing();




}
