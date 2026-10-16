package com.ecommercie.product_service.DTO;

import com.ecommercie.product_service.Model.Categories;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;

@Data
public class ProductRequestDto {
    @NotNull
    private String name;
    private String description;
    private String price;
    private String image;
}
