package com.salesianostriana.dam.ejemplo_jwt.user.service;

import com.salesianostriana.dam.ejemplo_jwt.user.dto.CreateUsuarioDto;
import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.user.model.UsuarioRole;
import com.salesianostriana.dam.ejemplo_jwt.user.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumSet;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public Usuario createUser(CreateUsuarioDto usuarioDto) {

        return usuarioRepository.save(usuarioDto.toUsuario(passwordEncoder, EnumSet.of(UsuarioRole.USER)));
    }

    @Transactional
    public Usuario createAdmin(CreateUsuarioDto usuarioDto) {

        return usuarioRepository.save(usuarioDto.toUsuario(passwordEncoder, EnumSet.of(UsuarioRole.ADMIN)));
    }

    @Transactional
    public Usuario changeRoleToAdmin(String username) {

        return usuarioRepository.findFirstByUsername(username)
                .map(usuario -> {

                    usuario.setRoles(EnumSet.of(UsuarioRole.ADMIN));

                    return usuarioRepository.save(usuario);
                }).orElseThrow(() -> new UsernameNotFoundException("No se ha encontrado el usuario con nombre de usuario: %s".formatted(username)));
    }

    @Transactional
    public Usuario changeRoleToUser(String username) {

        return usuarioRepository.findFirstByUsername(username)
                .map(usuario -> {

                    usuario.setRoles(EnumSet.of(UsuarioRole.ADMIN));

                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new UsernameNotFoundException("No se ha encontrado el usuario con nombre de usuario: %s".formatted(username)));
    }
}
