package com.ecommercie.product_service.security;

import com.ecommercie.product_service.Model.Users;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    final UserRegisterationService userRegisterationService;
    final private AuthenticationManager authenticationManager;
    final private  JwtService jwtService;
    public AuthController(UserRegisterationService userRegisterationService,AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRegisterationService= userRegisterationService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    @PostMapping("/")
    public String registerUser(@RequestBody Users user){
      return " registed users "+ userRegisterationService.registerUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto){
        Users user=new Users();
        user.setEmail(loginRequestDto.getUsername());
        user.setPassword(loginRequestDto.getPassword());
        String email =
                jwtService.parseToken(jwtService.generateToken(user));

        System.out.println(email);

        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword()));
        if(authentication.isAuthenticated()){

            return jwtService.generateToken(user);
        }
        return "Invalid username or password";



    }
}
