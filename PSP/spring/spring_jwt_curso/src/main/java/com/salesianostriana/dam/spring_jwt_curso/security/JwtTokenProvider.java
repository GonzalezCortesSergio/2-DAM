package com.salesianostriana.dam.spring_jwt_curso.security;

import com.salesianostriana.dam.spring_jwt_curso.model.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

@Component
@Log
public class JwtTokenProvider {

    @Value("${app.security.jwt.secret}")
    private String jwtSecret;

    @Value("${app.security.jwt.expiration}")
    private Long jwtDurationSeconds;

    private SecretKey secretKey;

    private JwtParser parser;

    @PostConstruct
    public void init() {

        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        secretKey = Keys.hmacShaKeyFor(keyBytes);

        parser = Jwts.parser()
                .verifyWith(secretKey)
                .build();
    }

    public String generateToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return Jwts.builder()
                .header()
                .add("typ", "JWT")
                .and()
                .subject(usuario.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + (jwtDurationSeconds * 1000)))
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact();
    }

    public UUID getIdFromToken(String token) {
        return UUID.fromString(parser.parseSignedClaims(token).getPayload().getSubject());
    }

    public boolean isValidToken(String token) {

        if(!StringUtils.hasLength(token))
            return false;

        try {
            parser.parseSignedClaims(token);
            return true;
        }catch (SignatureException e) {
            log.info("Error en la firma del token");
        }catch (MalformedJwtException | UnsupportedJwtException e) {
            log.info("Token incorrecto");
        }catch (ExpiredJwtException e) {
            log.info("Token expirado");
        }
        return false;
    }
}
