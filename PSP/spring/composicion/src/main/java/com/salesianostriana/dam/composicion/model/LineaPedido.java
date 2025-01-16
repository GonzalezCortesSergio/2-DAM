package com.salesianostriana.dam.composicion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@IdClass(LineaPedidoId.class)
public class LineaPedido {

    @Id
    @GeneratedValue
    private Long id;

    @Id
    @ManyToOne
    private Pedido pedido;

    private int cantidad;

    private double precioVenta;
}
