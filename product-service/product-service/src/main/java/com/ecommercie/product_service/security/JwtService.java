package com.ecommercie.product_service.security;

import com.ecommercie.product_service.Model.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private static final String JWT_SECRET = "jsdljlsjflsjflsjflksflkslfkslkflskl";
    private Key signingKey(){
        return  Keys.hmacShaKeyFor(JWT_SECRET.getBytes());

    }
    public String generateToken(Users user){
        return Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(signingKey())
                .compact();
    }
    public String parseToken(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) signingKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    public boolean isTokenExpired(String token){
        return Jwts.parser()
                .verifyWith((SecretKey)signingKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration()
                .before(new Date());
    }
    public String extractUsername(String token){

        return Jwts.parser()
                .verifyWith((SecretKey)signingKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    public boolean validateToken(
            String token,
            UserDetails userDetails){

        String username=extractUsername(token);

        return username.equals(
                userDetails.getUsername())
                &&
                !isTokenExpired(token);
    }
}
