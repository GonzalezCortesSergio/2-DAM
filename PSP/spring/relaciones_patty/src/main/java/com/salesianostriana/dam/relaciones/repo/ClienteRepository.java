package com.salesianostriana.dam.relaciones.repo;

import com.salesianostriana.dam.relaciones.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
