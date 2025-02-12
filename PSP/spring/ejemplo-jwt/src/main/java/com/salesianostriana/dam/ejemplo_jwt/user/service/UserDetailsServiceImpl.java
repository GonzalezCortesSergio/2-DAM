package com.salesianostriana.dam.ejemplo_jwt.user.service;

import com.salesianostriana.dam.ejemplo_jwt.user.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioService.findFirstByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Nombre de usuario no encontrado"));
    }
}
