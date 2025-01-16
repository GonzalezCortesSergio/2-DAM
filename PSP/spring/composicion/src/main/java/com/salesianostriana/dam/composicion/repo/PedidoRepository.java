package com.salesianostriana.dam.composicion.repo;

import com.salesianostriana.dam.composicion.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
