package com.piturria.TasksWebApp.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {
    //https://www.gigacalculator.com/randomizers/random-alphanumeric-generator.php
    // 60 length so it produces >256bits so JWT can produce token
    // The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used
    // with HMAC-SHA algorithms MUST have a size >= 256 bits
    //private String fakeKey="3wcP8AeBh5xAzPBowdHJW3cprsV0YmPfhsMWHycKHtCBt2LqiDbYGg0a8Cen";
    private String stringKey ="";

    public JWTService() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            stringKey=Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String username) {     //https://www.jwt.io
//        https://www.scottbrady.io/tools/jwt
//        Header: { "alg": "HS256" }
//        Decoded Payload: { "sub": "admin", "iat": 1753655329, "exp": 1753655929 }
//        Generate Hash with encoding algorithm
        String fakeJWT="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc1MzY1NTMyOSwiZXhwIjoxNzUzNjU1OTI5fQ.aRSVTOwK0iVyAaSPp6XlwAuDy68zLY6qnbGTHs1Xm3Q";

        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims().add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000*60*10))      //expires in 10 minutes
                .and()
                .signWith(getKey())
                .compact();

    }

    private SecretKey getKey() {
        byte [] keyBytes = Decoders.BASE64.decode(stringKey);
        return Keys.hmacShaKeyFor(keyBytes);
        //validate on jwt.io with base64 flag: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYXZpbiIsImlhdCI6MTcyMjE3MjMwNiwiZXhwIjoxNzIyM
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
