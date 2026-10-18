package com.ecommercie.product_service.security;

import com.ecommercie.product_service.Model.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterationService {
    final private UserRepository userRepository;
    final private PasswordEncoder passwordEncoder;
    public UserRegisterationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Users registerUser(Users user){
        Users user1=new Users();
        user1.setEmail(user.getEmail());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setRole(user.getRole());
        return userRepository.save(user1);
    }
}
