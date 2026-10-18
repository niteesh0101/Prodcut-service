package com.ecommercie.product_service.DTO;

import com.ecommercie.product_service.Model.Categories;
import com.ecommercie.product_service.Model.product;
import lombok.Data;

import java.util.Optional;

@Data
public class MapperDto {
    public static product  toProdcut(ProductRequestDto p){
        product p1=new product();
        p1.setName(p.getName());
        p1.setDescription(p.getDescription());
        p1.setPrice(p.getPrice());
        p1.setImage(p.getImage());
        return p1;
    }
    public static ProdcutResponseDto toProdcutResponseDto(product p){
        ProdcutResponseDto p1=new ProdcutResponseDto();
        p1.setName(p.getName());
        p1.setDescription(p.getDescription());
        p1.setPrice(p.getPrice());
        p1.setImage(p.getImage());
        return p1;
    }
    public static Categories toCategory(CategoriesRequestDto c){
        Categories c1=new Categories();
        c1.setCategory(c.getCategory());
        c1.setDescription(c.getDescription());
        c1.setImageUrl(c.getImageUrl());
        c1.setIsActive(c.getIsActive());
        return c1;

    }
    public static CategoriesResponseDto  toCategerryResponse(Categories c){
        CategoriesResponseDto c1=new CategoriesResponseDto();
        c1.setCategory(c.getCategory());
        c1.setDescription(c.getDescription());
        c1.setImageUrl(c.getImageUrl());
        c1.setIsActive(c.getIsActive());
        return c1;
    }

    public static ProdcutResponseDto toProdcutResponseDto(Optional<product> product) {

        ProdcutResponseDto p1=new ProdcutResponseDto();
        p1.setName(product.get().getName());
        p1.setDescription(product.get().getDescription());
        p1.setPrice(product.get().getPrice());
        p1.setImage(product.get().getImage());
        return p1;
    }
}
