package com.meninasnaestante.meninas_na_estante.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.meninasnaestante.meninas_na_estante.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String segredo;


    public String generateToken(Usuario usuario) {
        try{
            Algorithm algoritmo = Algorithm.HMAC256(segredo);
            String token = JWT.create().withIssuer("login-auth-api").withSubject(usuario.getEmail()).withExpiresAt(this.generateExpirationDate()).sign(algoritmo);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao autenticar.");
        }


    }

    public String validateToken(String token) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(segredo);
            return JWT.require(algoritmo).withIssuer("login-auth-api").build().verify(token).getSubject();
        } catch(JWTVerificationException e){
            return null;
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);
    }
}
