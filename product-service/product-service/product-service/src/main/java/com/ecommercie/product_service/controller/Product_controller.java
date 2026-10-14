package com.ecommercie.product_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ecom/product")
public class Product_controller {
    @GetMapping
    public String prodcts(){
        return "hello Niteesh please collect your first prodct";
    }
}
