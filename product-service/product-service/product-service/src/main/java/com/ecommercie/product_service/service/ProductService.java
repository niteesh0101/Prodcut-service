package com.ecommercie.product_service.service;

import com.ecommercie.product_service.DTO.MapperDto;
import com.ecommercie.product_service.DTO.ProdcutResponseDto;
import com.ecommercie.product_service.DTO.ProductRequestDto;
import com.ecommercie.product_service.Model.Categories;
import com.ecommercie.product_service.Model.product;
import com.ecommercie.product_service.Repositories.Catorgries_repo;
import com.ecommercie.product_service.Repositories.product_repo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final product_repo productRepo;
    private final Catorgries_repo catorgries_repo;

    public ProductService(product_repo productRepo, Catorgries_repo catorgries_repo) {
        this.productRepo = productRepo;
        this.catorgries_repo = catorgries_repo;

    }
    public ResponseEntity<ProdcutResponseDto>  addProduct(ProductRequestDto prodcutReqquest){
        product product = MapperDto.toProdcut(prodcutReqquest);
        productRepo.save(product);
        return ResponseEntity.ok().body(MapperDto.toProdcutResponseDto(product));

    }
    public ResponseEntity<List<ProdcutResponseDto>> getAllProduct(){
        List<product> products=productRepo.findAll();
        if(products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<ProdcutResponseDto> prodcutResponseDtos=new ArrayList<>();
        for(product p:products){
            prodcutResponseDtos.add(MapperDto.toProdcutResponseDto(p)) ;
        }
        return ResponseEntity.ok().body(prodcutResponseDtos);
    }
    public ResponseEntity<ProdcutResponseDto> getProduct(Integer productId){
      Optional<product> product=productRepo.findById(productId);
      if(product.isEmpty()){
          new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
        return ResponseEntity.ok().body(MapperDto.toProdcutResponseDto(product));
    }
    public ResponseEntity<ProdcutResponseDto> updateProduct(Integer productId, ProductRequestDto productRequestDto){
        product product= productRepo.findById(productId).orElseThrow(() -> new RuntimeException("product not find"));

        //product newProduct=MapperDto.toProdcut(productRequestDto);
        product.setName(productRequestDto.getName());
        product.setImage(productRequestDto.getImage());
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
       productRepo.save(product);
       return ResponseEntity.ok().body(MapperDto.toProdcutResponseDto(product));
    }
    //method to delete the product by product id
    public ResponseEntity<ProdcutResponseDto> deleteProduct(Integer productId){
        Optional<product> product=productRepo.findById(productId);
        if(product.isEmpty()){
            new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        productRepo.deleteById(productId);
        productRepo.flush();
        return ResponseEntity.ok().body(MapperDto.toProdcutResponseDto(product));

    }

}
