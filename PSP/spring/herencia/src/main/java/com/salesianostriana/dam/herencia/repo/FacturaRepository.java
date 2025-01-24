package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.model.singletable.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
