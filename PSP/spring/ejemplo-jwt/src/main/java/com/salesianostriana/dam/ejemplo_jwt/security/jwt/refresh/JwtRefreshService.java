package com.salesianostriana.dam.ejemplo_jwt.security.jwt.refresh;

import com.salesianostriana.dam.ejemplo_jwt.security.error.RefreshTokenException;
import com.salesianostriana.dam.ejemplo_jwt.security.jwt.access.JwtProvider;
import com.salesianostriana.dam.ejemplo_jwt.user.dto.UsuarioResponseDto;
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
    private final JwtProvider provider;


    public JwtRefresh create(Usuario usuario) {
        refreshRepository.deleteByUsuario(usuario);
        return refreshRepository.save(
                JwtRefresh.builder()
                        .usuario(usuario)
                        .expireAt(Instant.now().plusSeconds(durationInMinutes * 60L))
                        .build()
        );
    }


    public JwtRefresh verify(JwtRefresh refreshToken) {

        if (refreshToken.getExpireAt().compareTo(Instant.now()) < 0) {

            refreshRepository.delete(refreshToken);
            throw new RefreshTokenException("Token de refresco caducado. Porfavor, vuelva a loguearse");
        }

        return refreshToken;
    }

    public UsuarioResponseDto refreshToken(String refreshToken) {

        return refreshRepository.findById(UUID.fromString(refreshToken))
                .map(this::verify)
                .map(JwtRefresh::getUsuario)
                .map(usuario -> {
                    String accessToken = provider.generateToken(usuario);
                    JwtRefresh refreshedToken = this.create(usuario);

                    return UsuarioResponseDto.of(usuario, accessToken, refreshedToken.getToken());

                })
                .orElseThrow(() -> new RefreshTokenException("Token de refresco no encontrado. Por favor, vuelva a iniciar sesión"));
    }
}
