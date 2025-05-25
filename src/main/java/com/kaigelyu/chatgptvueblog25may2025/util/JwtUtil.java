package com.kaigelyu.chatgptvueblog25may2025.util;

import com.kaigelyu.chatgptvueblog25may2025.entity.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String secret = "my-secret-key"; // 可放到 application.properties
    private final long expiration = 86400000; // 1天（单位：毫秒）

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims parseToken(String token) throws ExpiredJwtException {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}

