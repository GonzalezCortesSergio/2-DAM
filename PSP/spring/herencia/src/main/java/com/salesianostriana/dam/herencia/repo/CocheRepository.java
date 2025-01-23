package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.model.mappedsuperclass.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocheRepository extends JpaRepository<Coche, Long> {
}
