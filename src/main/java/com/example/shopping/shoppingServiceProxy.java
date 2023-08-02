package com.example.shopping;


import com.example.shopping.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name="shoppingservice" , url = "")
public interface shoppingServiceProxy {



    //TO BE Modified
    //upon completion of Open API Spec.

/*
    @PostMapping("/api/shopping/place")
    void putintoCart(@RequestBody Product product);

    @PostMapping("/api/shopping/Nplace")
    void putNintoCart(@RequestBody int N, Product product);

    @PostMapping("/api/shopping/Swishlist")
    void savetoWishlist(@RequestBody String sku);



    @PostMapping("/api/shopping/remove")
    void PulloutCart(@RequestBody String SKU);

    @PostMapping("/api/shopping/Nremove")
    void PulloutNCart(@RequestBody int N, String SKU);


    @PostMapping("/api/shopping/complete")
    void checkout();
*/

}
