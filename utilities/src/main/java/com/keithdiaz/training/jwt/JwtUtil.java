package com.keithdiaz.training.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {

    @Value("${JWT_SECRET_KEY}")
    private String secretKey;
    
    private Key getSigningKey(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        byte[] apiKeySecretBytes = secretKey.getBytes();
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;

    }

    public String generateToken(String username){
        Key signingKey = getSigningKey();
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
            .signWith(signingKey, SignatureAlgorithm.HS512)
            .compact();
    }

     public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("JWT expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("Malformed JWT: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument token: " + e.getMessage());
        }
        return false;
    }

    public String extractUsername(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token);
        return claims.getBody().getSubject();
    }
    
}
