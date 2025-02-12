package com.salesianostriana.dam.ejemplo_jwt.user.dto;

public record LoginRequest(
        String username,
        String password
) {
}
