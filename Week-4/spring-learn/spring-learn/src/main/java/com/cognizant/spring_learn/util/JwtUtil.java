package com.cognizant.spring_learn.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "MySuperSecretKeyForJwtGeneration12345"; // Must be at least 256-bit for HS256

    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 minutes
            .signWith(key)
            .compact();
    }
}
