package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.model.mappedsuperclass.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}
