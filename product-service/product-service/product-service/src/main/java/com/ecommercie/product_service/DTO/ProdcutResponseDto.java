package com.ecommercie.product_service.DTO;

import com.ecommercie.product_service.Model.Categories;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProdcutResponseDto {
    private String name;
    private String description;
    private String price;
    private String image;

}
