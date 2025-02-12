package com.salesianostriana.dam.ejemplo_jwt.user.dto;

import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;

public record LoginResponse(
        UsuarioResponseDto usuario,
        String token
) {

    public static LoginResponse of (Usuario usuario, String token) {

        return new LoginResponse(
                UsuarioResponseDto.of(usuario),
                token
        );
    }
}
