package com.example.marketing;

import com.example.marketing.controller.MarketingController;
import com.example.marketing.entity.Catalog;
import com.example.marketing.entity.Product;
import com.example.marketing.util.CSVRead;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class MarketingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketingApplication.class, args);


	}

}
