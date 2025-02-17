package com.salesianostriana.dam.ejemplo_jwt.security.error;

import io.jsonwebtoken.JwtException;

public class RefreshTokenException extends JwtException {
    public RefreshTokenException(String s) {
        super(s);
    }
}
