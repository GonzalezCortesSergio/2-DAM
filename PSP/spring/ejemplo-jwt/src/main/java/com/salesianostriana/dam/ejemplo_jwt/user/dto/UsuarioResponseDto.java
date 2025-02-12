package com.salesianostriana.dam.ejemplo_jwt.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;

import java.time.LocalDateTime;

public record UsuarioResponseDto(
        String id,
        String username,
        String avatar,
        String fullName,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime createdAt
) {

    public static UsuarioResponseDto of (Usuario usuario) {

        return new UsuarioResponseDto(
                usuario.getId().toString(),
                usuario.getUsername(),
                usuario.getAvatar(),
                usuario.getFullName(),
                usuario.getCreatedAt()
        );
    }
}
