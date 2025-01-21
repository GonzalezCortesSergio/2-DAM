package com.salesianostriana.dam.modelodatos_ejercicio3.repo;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
