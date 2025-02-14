package com.salesianostriana.dam.ejemplo_jwt.seed;

import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.user.model.UsuarioRole;
import com.salesianostriana.dam.ejemplo_jwt.user.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){

        Usuario admin = Usuario.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .fullName("admin")
                .avatar("admin.png")
                .roles(EnumSet.of(UsuarioRole.ADMIN))
                .build();

        usuarioRepository.save(admin);

    }
}
