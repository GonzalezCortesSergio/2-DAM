package com.salesianostriana.dam.ejemplo_jwt.security.jwt.refresh;

import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface JwtRefreshRepository extends JpaRepository<JwtRefresh, UUID> {

    @Modifying
    @Transactional
    void deleteByUsuario(Usuario usuario);

}
