package com.salesianostriana.dam.spring_jwt_curso.dto;

public record LoginRequest(
        String username,
        String password
) {
}
