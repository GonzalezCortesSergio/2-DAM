package com.salesianostriana.dam.modelodatos_ejercicio3.repo;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {

    List<Bicicleta> findByEstado(String estado);

    List<Bicicleta> findByEstacionNombre(String nombre);

    boolean existsBicicletaByEstacionNumero(String numero);
}
