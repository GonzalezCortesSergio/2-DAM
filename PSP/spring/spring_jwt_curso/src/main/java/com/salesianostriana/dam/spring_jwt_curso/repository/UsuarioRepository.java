package com.salesianostriana.dam.spring_jwt_curso.repository;

import com.salesianostriana.dam.spring_jwt_curso.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByUsername(String username);
}
