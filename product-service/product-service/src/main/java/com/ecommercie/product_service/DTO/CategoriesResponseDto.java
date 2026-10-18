package com.ecommercie.product_service.DTO;

import lombok.Data;

@Data
public class CategoriesResponseDto {
    private String category;
    private String description;
    private String imageUrl;
    private Boolean isActive;
}
