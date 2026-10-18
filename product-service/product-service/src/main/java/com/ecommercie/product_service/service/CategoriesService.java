package com.ecommercie.product_service.service;

import com.ecommercie.product_service.DTO.CategoriesRequestDto;
import com.ecommercie.product_service.DTO.CategoriesResponseDto;
import com.ecommercie.product_service.DTO.MapperDto;
import com.ecommercie.product_service.Model.Categories;
import com.ecommercie.product_service.Repositories.Catorgries_repo;
import com.ecommercie.product_service.Repositories.product_repo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoriesService {
    private final Catorgries_repo catorgries_repo;
    public CategoriesService(Catorgries_repo catorgries_repo) {
    this.catorgries_repo = catorgries_repo;}
    public ResponseEntity<CategoriesResponseDto> addCategories(CategoriesRequestDto categories){
        Categories categories1= MapperDto.toCategory(categories);
        catorgries_repo.save(categories1);
        return ResponseEntity.ok().body(MapperDto.toCategerryResponse(categories1));

    }
    public ResponseEntity<List<CategoriesResponseDto>> getAllCategories(){
        List<Categories> categories1= catorgries_repo.findAll();
        LinkedList<CategoriesResponseDto> categoriesResponseDto=new LinkedList<>();
        for(Categories categories:categories1){
            categoriesResponseDto.add(MapperDto.toCategerryResponse(categories));
        }
        return ResponseEntity.ok().body(categoriesResponseDto);
    }
    //get catogries by id
    public ResponseEntity<CategoriesResponseDto> getAllCategoriesByCategoryById(Integer categoryID){
        return ResponseEntity.ok().body(MapperDto.toCategerryResponse(catorgries_repo.findById(categoryID).orElseThrow(()->new RuntimeException("Product nto found for id"+categoryID))));

    }
    public ResponseEntity<CategoriesResponseDto> updateCategories(Integer id,CategoriesRequestDto categories){
        Categories categories1= catorgries_repo.findById(id).orElseThrow(()->new RuntimeException("Product not found for id"+id));
        categories1.setCategory(categories.getCategory());
        categories1.setDescription(categories.getDescription());
        categories1.setIsActive(categories.getIsActive());
        categories1.setIsActive(categories.getIsActive());
        catorgries_repo.save(categories1);
        return ResponseEntity.ok().body(MapperDto.toCategerryResponse(categories1));
    }

}
