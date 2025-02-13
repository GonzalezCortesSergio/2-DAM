package com.salesianostriana.dam.ejemplo_jwt.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UsuarioResponseDto(
        String id,
        String username,
        String avatar,
        String fullName,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime createdAt,
        String token,
        String refreshToken
) {

    public static UsuarioResponseDto of (Usuario usuario) {

        return new UsuarioResponseDto(
                usuario.getId().toString(),
                usuario.getUsername(),
                usuario.getAvatar(),
                usuario.getFullName(),
                usuario.getCreatedAt(),
                null,
                null
        );
    }

    public static UsuarioResponseDto of (Usuario usuario, String token, String refreshToken) {

        return new UsuarioResponseDto(
                usuario.getId().toString(),
                usuario.getUsername(),
                usuario.getAvatar(),
                usuario.getFullName(),
                usuario.getCreatedAt(),
                token,
                refreshToken
        );
    }
}
