package com.salesianostriana.dam.ejemplo_jwt.user.service;

import com.salesianostriana.dam.ejemplo_jwt.user.dto.CreateUsuarioDto;
import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.user.model.UsuarioRole;
import com.salesianostriana.dam.ejemplo_jwt.user.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public Usuario findByUsername(String username) {

        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No se ha encontrado el usuario: %s".formatted(username)));
    }

    public Usuario createUser(CreateUsuarioDto usuarioDto) {

        return usuarioRepository.save(usuarioDto.toUsuario(passwordEncoder, EnumSet.of(UsuarioRole.USER)));
    }

    public Usuario createAdmin(CreateUsuarioDto usuarioDto) {

        return usuarioRepository.save(usuarioDto.toUsuario(passwordEncoder, EnumSet.of(UsuarioRole.ADMIN)));
    }

    public Usuario findById(UUID id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado al usuario con ID: %s".formatted(id.toString())));
    }
}
