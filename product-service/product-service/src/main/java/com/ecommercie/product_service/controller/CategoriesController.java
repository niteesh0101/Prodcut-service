package com.ecommercie.product_service.controller;

import com.ecommercie.product_service.DTO.CategoriesRequestDto;
import com.ecommercie.product_service.DTO.CategoriesResponseDto;
import com.ecommercie.product_service.Model.Categories;
import com.ecommercie.product_service.service.CategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecom/product/catogries")

public class CategoriesController {
    private CategoriesService categoriesService;
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    @PostMapping("/addCatogries")
    public ResponseEntity<CategoriesResponseDto> addCategories(@RequestBody CategoriesRequestDto categories){
        return categoriesService.addCategories(categories);
    }
    @GetMapping("/getAllCatogries")
    public ResponseEntity<List<CategoriesResponseDto>> getAllCategories(){
     return categoriesService.getAllCategories();
    }
    @GetMapping("/getCatogries/{Id}")
    public ResponseEntity<CategoriesResponseDto> getCatogries(@PathVariable("Id") Integer Id){
        return categoriesService.getAllCategoriesByCategoryById(Id);
    }
    @PutMapping("/updateCatogries/{Id}")
    public ResponseEntity<CategoriesResponseDto> updateCatogries(@PathVariable("Id") Integer Id, @RequestBody CategoriesRequestDto categories){
        return categoriesService.updateCategories(Id,categories);
    }
}
