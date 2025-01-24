package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.model.singletable.FacturaSinIva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaSinIvaRepository extends JpaRepository<FacturaSinIva, Long> {
}
