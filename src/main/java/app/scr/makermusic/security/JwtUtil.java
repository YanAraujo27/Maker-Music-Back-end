package app.scr.makermusic.security;


import app.scr.makermusic.exception.InvalidTokenException;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;


import java.security.Key;
import java.util.Date;



public class JwtUtil {
    private final Key key;

    public JwtUtil() {
        this.key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);
    }

    // Gera um token para um usuário com base no email e role
    public String generateToken(String email, String role) {
        long expirationTime = 1000 * 60 * 60 * 10; // 10 horas

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();
    }

    // Validação e extração de informações do token
    public Jws<Claims> validateToken(String token) throws JwtException {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
        } catch (JwtException e) {
            throw new InvalidTokenException("Invalid or expired token");
        }
    }
}