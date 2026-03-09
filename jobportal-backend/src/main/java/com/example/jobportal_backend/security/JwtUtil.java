package com.example.jobportal_backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "jobportalSecretKey12345678901234567890";

    // Convert secret string to secure key
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    // Generate Token
    public static String generateToken(String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract email
    public static String extractEmail(String token) {
        return extractClaims(token).getSubject();
    }

    // Extract role
    public static String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    // Validate token
    public static boolean validateToken(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract claims
    private static Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}