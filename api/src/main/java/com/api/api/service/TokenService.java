package com.api.api.service;

import org.springframework.stereotype.Component;

import com.api.api.controllers.login.LoginDTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class TokenService {
    private String secreti = "1234567890";

    public String createJWT(LoginDTO login) {
        Algorithm algorithm = Algorithm.HMAC256(this.secreti);

        String token = JWT.create()
                .withIssuer("auth-api")
                .withSubject("user")
                .withClaim("user", login.user())
                .sign(algorithm);
        return token;
    }

    public Claim verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(this.secreti);

        Claim jj = JWT
                .require(algorithm)
                .withIssuer("auth-api")
                .build()
                .verify(token).getClaim("user");
         
                return jj;

    }
}
