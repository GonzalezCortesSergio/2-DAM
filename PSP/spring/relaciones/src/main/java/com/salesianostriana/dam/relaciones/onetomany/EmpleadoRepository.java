package com.salesianostriana.dam.relaciones.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
