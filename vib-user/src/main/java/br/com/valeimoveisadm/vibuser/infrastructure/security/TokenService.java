package br.com.valeimoveisadm.vibuser.infrastructure.security;


import br.com.valeimoveisadm.vibuser.adapter.outbound.persistence.entity.UserEntity;
import br.com.valeimoveisadm.vibuser.application.core.exceptions.TokenException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UserEntity user) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("valeimoveis")
                    .withSubject(user.getEmail())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new TokenException("Error to generate a new Token");
        }
    }

    public String getSubject(String jwt) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("valeimoveis")
                    .build()
                    .verify(jwt)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new TokenException("JWT Token isn't valid or has expired");
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }

}
