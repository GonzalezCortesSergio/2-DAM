package com.salesianostriana.dam.relaciones.dto;

import com.salesianostriana.dam.relaciones.model.Cliente;

public record GetClienteFromTatuador(
        Long id,
        String nombre
) {

    public static GetClienteFromTatuador of(Cliente cliente) {

        return new GetClienteFromTatuador(
                cliente.getId(),
                cliente.getNombre()
        );
    }
}
