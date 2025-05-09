package com.lazzuri.CashPlus.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lazzuri.CashPlus.model.Token;
import com.lazzuri.CashPlus.model.User;
import com.lazzuri.CashPlus.model.UserRole;

@Service
public class TokenService {

    private final Long DURATION = 10L; //10 min
    private final Algorithm ALG = Algorithm.HMAC256("secret");

    public Token createToken(User user) {
        String token = JWT.create()
            .withSubject("1")
            .withExpiresAt(LocalDateTime.now().plusMinutes(DURATION).toInstant(ZoneOffset.ofHours(-3)))
            .sign(ALG);

        return new Token(
            token, 22L, "Bearer", "ROLE_USER"
        );

    }

    public User getUserFromToken(String token) {
        var verifiedToken = JWT.require(ALG)
                                .build()
                                .verify(token);

        return User
                    .builder()
                    .id(Long.parseLong( verifiedToken.getSubject() ))
                    .email(verifiedToken.getClaim("email").toString())
                    .role(UserRole.ADMIN) //TODO
                    .build();
                                
    }
    
}
