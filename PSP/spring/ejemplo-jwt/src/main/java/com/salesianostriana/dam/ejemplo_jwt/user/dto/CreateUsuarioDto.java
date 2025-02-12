package com.salesianostriana.dam.ejemplo_jwt.user.dto;

import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.user.model.UsuarioRole;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.EnumSet;
import java.util.Set;

public record CreateUsuarioDto(
        String username,
        String password,
        String passwordRepeat,
        String avatar,
        String fullName
) {

    public Usuario toUsuario(PasswordEncoder passwordEncoder, EnumSet<UsuarioRole> roles) {

        return Usuario.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .avatar(avatar)
                .fullName(fullName)
                .roles(roles)
                .build();
    }
}
