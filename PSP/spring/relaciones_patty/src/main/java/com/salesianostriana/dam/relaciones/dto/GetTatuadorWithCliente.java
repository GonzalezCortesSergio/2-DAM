package com.salesianostriana.dam.relaciones.dto;

import com.salesianostriana.dam.relaciones.model.Tatuador;

import java.util.Set;
import java.util.stream.Collectors;

public record GetTatuadorWithCliente(
        Long id,
        String nombre,
        String estilo,
        Set<GetClienteFromTatuador> clientes
) {

    public static GetTatuadorWithCliente of (Tatuador tatuador) {

        return new GetTatuadorWithCliente(
                tatuador.getId(),
                tatuador.getNombre(),
                tatuador.getEstilo(),
                tatuador.getClientes()
                        .stream()
                        .map(GetClienteFromTatuador::of)
                        .collect(Collectors.toSet())
        );
    }
}
