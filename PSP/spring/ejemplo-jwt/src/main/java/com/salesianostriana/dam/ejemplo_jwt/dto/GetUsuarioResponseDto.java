package com.salesianostriana.dam.ejemplo_jwt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianostriana.dam.ejemplo_jwt.model.Usuario;

import java.time.LocalDateTime;

public record GetUsuarioResponseDto(
     String id,
     String username,
     String avatar,
     String nombreCompleto,
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
     LocalDateTime createdAt
) {

    public static GetUsuarioResponseDto of (Usuario usuario) {

        return new GetUsuarioResponseDto(
                usuario.getId().toString(),
                usuario.getUsername(),
                usuario.getAvatar(),
                usuario.getNombreCompleto(),
                usuario.getCreatedAt()
        );
    }
}
