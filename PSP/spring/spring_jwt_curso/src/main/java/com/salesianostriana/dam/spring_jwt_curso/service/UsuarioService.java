package com.salesianostriana.dam.spring_jwt_curso.service;

import com.salesianostriana.dam.spring_jwt_curso.dto.CreateUserDto;
import com.salesianostriana.dam.spring_jwt_curso.model.UserAuthority;
import com.salesianostriana.dam.spring_jwt_curso.model.Usuario;
import com.salesianostriana.dam.spring_jwt_curso.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario findByUsername(String username) {

        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No se ha encontrado el usuario %s".formatted(username)));
    }

    public Usuario findById(UUID id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("No se ha encontrado ar nota"));
    }

    public Usuario save(CreateUserDto userDto) {

        return usuarioRepository.save(userDto.toUsuario(passwordEncoder));
    }

    public Usuario changeRole(String username, String role) {

        Set<UserAuthority> userAuthorities;

        if(role.equalsIgnoreCase("write"))
            userAuthorities = EnumSet.of(UserAuthority.WRITE);
        else
            userAuthorities = EnumSet.of(UserAuthority.READ);

        return usuarioRepository.findByUsername(username)
                .map(usuario -> {

                    usuario.setRoles(userAuthorities);

                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new UsernameNotFoundException("No se ha encontrado el usuario: %s".formatted(username)));
    }
}
