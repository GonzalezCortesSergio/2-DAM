package com.salesianostriana.dam.ejemplo_jwt.user.repository;

import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByUsername(String username);
}
