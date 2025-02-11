package com.salesianostriana.dam.spring_jwt_curso.dto;

import com.salesianostriana.dam.spring_jwt_curso.model.UserAuthority;
import com.salesianostriana.dam.spring_jwt_curso.model.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

public record CreateUserDto(
        String username,
        String email,
        String password,
        String passwordRepeat
) {

    public Usuario toUsuario(PasswordEncoder passwordEncoder) {

        return Usuario.builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .roles(EnumSet.of(UserAuthority.READ))
                .build();
    }
}
