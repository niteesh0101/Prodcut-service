package com.ecommercie.product_service.controller;

import com.ecommercie.product_service.DTO.ProdcutResponseDto;
import com.ecommercie.product_service.DTO.ProductRequestDto;
import com.ecommercie.product_service.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecom/product")
public class Product_controller {
    private ProductService productService;
    public Product_controller(ProductService productService){
        this.productService=productService;
    }
    @GetMapping
    public String prodcts(){
        return "hello Niteesh please collect your first prodct";
    }
    @PostMapping("/addProduct/p")
    public ResponseEntity<ProdcutResponseDto> addProduct(@RequestBody ProductRequestDto p){
      return productService.addProduct(p);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProdcutResponseDto> deleteProduct(@PathVariable("id") int id){
        return productService.deleteProduct(id);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<ProdcutResponseDto> updateProduct(@RequestBody ProductRequestDto p,@PathVariable Integer id){
        return productService.updateProduct(id,p);
    }
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProdcutResponseDto> getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }
    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProdcutResponseDto>> getAllProduct(){
        return productService.getAllProduct();
    }
}

