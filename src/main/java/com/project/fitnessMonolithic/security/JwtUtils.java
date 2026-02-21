package com.project.fitnessMonolithic.security;

import com.project.fitnessMonolithic.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtils {
    private String jwtSecretKey="askjdfaiuvnaejhfa5865asdvakbrfa65425";

    // here the secret key secure ho gya
    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }


    // now we only need payload for creation of token

    public String generateAccessToken(User user){
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId",user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSecretKey())
                .compact();
    }

    public String getUsernameFromToken(String token){
        Claims claims=Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }


}
