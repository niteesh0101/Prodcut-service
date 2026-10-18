package com.ecommercie.product_service.controller;

import com.ecommercie.product_service.Model.Users;
import com.ecommercie.product_service.service.CustomUserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthController {
    final CustomUserDetailsService customUserDetailsService;
    public AuthController(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }
    @PostMapping("/")
    public String registerUser(@RequestBody Users user){
      return " registed users "+ customUserDetailsService.registerUser(user);
    }
}
