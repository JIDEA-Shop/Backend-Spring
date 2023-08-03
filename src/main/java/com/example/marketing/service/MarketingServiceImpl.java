package com.example.marketing.service;

import com.example.marketing.entity.Catalog;
import com.example.marketing.entity.Product;
import com.example.marketing.repository.MarketingRepository;
import com.example.marketing.util.CSVRead;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@Service
public class MarketingServiceImpl implements MarketingService{

    Catalog catalog = new Catalog();

    MarketingRepository marketingRepository;

    public MarketingServiceImpl(
            @Autowired MarketingRepository marketingRepository
            ){

        this.marketingRepository = marketingRepository;

    }



    @Override
    public Product DisplayProduct(Product product) {

        return catalog.productDescription(product);

    }

    @Override
    public Collection<Product> DisplayCatalog() {

        System.out.println("Getting Catalog");
        return catalog.getCatalog();
    }

    @Override
    public void DiscountPrice(Product product) {

        catalog.markdown(product);

    }

    @Override
    public void loadCatalog(Collection<Product> cat) {

        catalog.uploadCatalog(cat);

    }

    @Override
    public void DownloadCatalog() {

        catalog.downloadCatalogFromS3();

    }


    @Override
    public void gotomarketing() {

        marketingRepository.saveAll(catalog.getCatalog());

    }
}
