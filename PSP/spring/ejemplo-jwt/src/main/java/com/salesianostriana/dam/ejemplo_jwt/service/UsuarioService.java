package com.salesianostriana.dam.ejemplo_jwt.service;

import com.salesianostriana.dam.ejemplo_jwt.dto.CreateUsuarioDto;
import com.salesianostriana.dam.ejemplo_jwt.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.model.UsuarioRol;
import com.salesianostriana.dam.ejemplo_jwt.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;


    public Usuario crearUsuarioUser(CreateUsuarioDto usuarioDto) {

        return usuarioRepository.save(usuarioDto.toUsuario(passwordEncoder, EnumSet.of(UsuarioRol.USER)));
    }

    public Usuario crearUsuarioAdmin(CreateUsuarioDto usuarioDto) {

        return usuarioRepository.save(usuarioDto.toUsuario(passwordEncoder, EnumSet.of(UsuarioRol.ADMIN)));
    }

    public Optional<Usuario> findById(UUID idUsuario) {

        return usuarioRepository.findById(idUsuario);
    }

    public Usuario findByUsername(String username) {

        return usuarioRepository.findFirstByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with username: %s".formatted(username)));
    }
}
