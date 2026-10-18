package com.ecommercie.product_service.DTO;

import lombok.Data;
import lombok.NonNull;

@Data
public class CategoriesRequestDto {
    @NonNull
    private String category;
    private String description;
    private String imageUrl;
    private Boolean isActive;
}
