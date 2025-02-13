package com.salesianostriana.dam.ejemplo_jwt.security.jwt.refresh;

import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.user.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JwtRefreshService {

    private final JwtRefreshRepository refreshRepository;

    @Value("${app.security.refresh.duration}")
    private int durationInMinutes;
    private final UsuarioRepository usuarioRepository;


    @Transactional
    public JwtRefresh create(Usuario usuario) {
        return refreshRepository.save(
                JwtRefresh.builder()
                        .usuario(usuario)
                        .expireAt(Instant.now().plusSeconds(durationInMinutes * 1000L))
                        .build()
        );
    }
}
