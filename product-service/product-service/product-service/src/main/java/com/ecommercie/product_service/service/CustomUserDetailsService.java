package com.ecommercie.product_service.service;

import com.ecommercie.product_service.Model.Users;
import com.ecommercie.product_service.Repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {

     final private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user= userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user is not registed for di" + username));

        return new CustomUserDetails(user);
    }
    public Users registerUser( Users user){
         Users user1=new Users();
         user1.setEmail(user.getEmail());
         user1.setPassword(passwordEncoder.encode(user.getPassword()));
         user1.setFirstName(user.getFirstName());
         user1.setLastName(user.getLastName());
         user1.setRole(user.getRole());
         return userRepository.save(user1);
    }
}
