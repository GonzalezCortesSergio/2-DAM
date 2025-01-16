package com.salesianostriana.dam.composicion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaPedidoId {

    private Long id;
    private Pedido pedido;
}
