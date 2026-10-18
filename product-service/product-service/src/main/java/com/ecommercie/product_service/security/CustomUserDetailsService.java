package com.ecommercie.product_service.security;

import com.ecommercie.product_service.Model.Users;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

     final private UserRepository userRepository;


    public CustomUserDetailsService(UserRepository userRepository ) {
        this.userRepository = userRepository;


    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user= userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user is not registed for di" + username));

        return new CustomUserDetails(user);
    }


}
