package com.salesianostriana.dam.ejemplo_jwt.security.jwt.access;

import com.salesianostriana.dam.ejemplo_jwt.security.error.JwtTokenException;
import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtProvider {

    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    @Value("${app.security.jwt.secret}")
    private String jwtSecret;

    @Value("${app.security.jwt.duration}")
    private Long jwtLifeInMinutes;

    private JwtParser parser;

    private SecretKey secretKey;


    @PostConstruct
    public void init() {


        secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        parser = Jwts.parser()
                .verifyWith(secretKey)
                .build();
    }


    public String generateToken(Authentication auth) {

        Usuario usuario = (Usuario) auth.getPrincipal();

        return generateToken(usuario);
    }

    public String generateToken(Usuario usuario) {

        Date tokenExpirationDateTime =
                Date.from(
                        LocalDateTime
                                .now()
                                .plusMinutes(jwtLifeInMinutes)
                                .atZone(ZoneId.systemDefault())
                                .toInstant()
                );

        return Jwts.builder()
                .header().type(TOKEN_TYPE)
                .and()
                .subject(usuario.getId().toString())
                .issuedAt(new Date())
                .expiration(tokenExpirationDateTime)
                .signWith(secretKey)
                .compact();
    }

    public UUID getUsuarioIdFromToken(String token) {

        return UUID.fromString(
                parser.parseSignedClaims(token).getPayload().getSubject()
        );
    }

    public boolean isTokenValid(String token) {

        try {
            parser.parseSignedClaims(token);
            return true;
        }catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            throw new JwtTokenException(ex.getMessage());
        }
    }
}
