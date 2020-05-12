package ru.itis.simpleblog.simple_blog.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import ru.itis.simpleblog.simple_blog.entity.UserEntity;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String createToken(UserEntity user) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", user.getId());
        data.put("username", user.getUsername());

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setClaims(data);

        return jwtBuilder.signWith(key).compact();
    }

    public UserEntity checkToken(String token) {
        Claims claims = null;
        try {
            claims = (Claims) Jwts.parserBuilder().setSigningKey(key).build().parse(token).getBody();
        } catch (JwtException e) {
            System.out.println("Token is not valid");
            throw new IllegalArgumentException(e);
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(claims.get("id", Long.class));
        userEntity.setUsername(claims.get("username", String.class));
        return userEntity;
    }
}
