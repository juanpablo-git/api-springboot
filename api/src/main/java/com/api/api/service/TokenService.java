package com.api.api.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class TokenService {
    private String secreti = "1234567890";

    public String createJWT(UserDetails login) {
        Algorithm algorithm = Algorithm.HMAC256(this.secreti);

        String token = JWT.create()
                .withIssuer("auth-api")
                .withSubject(login.getUsername())
                .sign(algorithm);
        return token;
    }

    public String verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(this.secreti);

        String jj = JWT
                .require(algorithm)
                .withIssuer("auth-api")
                .build()
                .verify(token)
                .getSubject();

        return jj;

    }
}
