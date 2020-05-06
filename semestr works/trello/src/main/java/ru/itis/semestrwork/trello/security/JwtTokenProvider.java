package ru.itis.semestrwork.trello.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.semestrwork.trello.dto.SignInDto;
import ru.itis.semestrwork.trello.entity.User;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    private final PasswordEncoder passwordEncoder;

    public JwtTokenProvider(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public Optional<Authentication> authenticate(HttpServletRequest servletRequest, String token) throws AuthenticationException {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Your token is invalid");
        }

        User user = new User();
        user.setId(claims.get("id", Long.class));
        user.setUsername(claims.get("username", String.class));

        return Optional.of(new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities()));
    }

    public String createToken(SignInDto userData, User user) {
        Map<String, Object> claimData = new HashMap<>();

        if (passwordEncoder.matches(userData.getPassword(), user.getHashPassword())) {
            claimData.put("id", user.getId());
            claimData.put("email", user.getEmail());

            return Jwts.builder()
                    .setSubject(user.getUsername())
                    .setClaims(claimData)
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
        } else throw new AccessDeniedException("Wrong data");
    }
}
