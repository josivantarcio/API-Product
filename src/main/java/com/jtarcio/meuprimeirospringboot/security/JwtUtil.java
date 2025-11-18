package com.jtarcio.meuprimeirospringboot.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {
    private static final Key chave = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86_400_000; // 1 day

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(java.util.Date.from(java.time.Instant.now().plusMillis(EXPIRATION_TIME)))
                .signWith(chave, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String extractUserName(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(chave)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
