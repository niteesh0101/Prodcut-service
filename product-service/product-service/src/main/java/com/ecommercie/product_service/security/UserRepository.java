package com.ecommercie.product_service.security;

import com.ecommercie.product_service.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
  public Optional<Users> findByEmail(String email);
}
