package com.salesianostriana.dam.ejemplo_jwt.dto;

import com.salesianostriana.dam.ejemplo_jwt.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.model.UsuarioRol;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.EnumSet;

public record CreateUsuarioDto(
        String username,
        String password,
        String passwordRepeat,
        String avatar,
        String nombreCompleto
) {

    public Usuario toUsuario(PasswordEncoder passwordEncoder, EnumSet<UsuarioRol> roles) {

        return Usuario.builder()
                .username(this.username())
                .password(passwordEncoder.encode(this.password()))
                .avatar(this.avatar())
                .nombreCompleto(this.nombreCompleto())
                .roles(roles)
                .build();
    }
}
