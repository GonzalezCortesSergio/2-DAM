package com.salesianostriana.dam.spring_jwt_curso.dto;

import com.salesianostriana.dam.spring_jwt_curso.model.UserAuthority;
import com.salesianostriana.dam.spring_jwt_curso.model.Usuario;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public record LoginReponse(
        String username,
        List<String> roles,
        String token
) {

    public static LoginReponse of (Usuario usuario, String token) {

        return new LoginReponse(
                usuario.getUsername(),
                usuario.getRoles()
                        .stream()
                        .map(UserAuthority::toString)
                        .toList(),
                token
        );
    }
}
