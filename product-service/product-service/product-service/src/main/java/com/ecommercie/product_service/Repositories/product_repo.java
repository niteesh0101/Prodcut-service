package com.ecommercie.product_service.Repositories;

import com.ecommercie.product_service.Model.Categories;
import com.ecommercie.product_service.Model.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface product_repo extends JpaRepository<product,Integer> {
}
