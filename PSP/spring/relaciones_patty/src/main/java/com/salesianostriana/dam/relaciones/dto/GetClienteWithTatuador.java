package com.salesianostriana.dam.relaciones.dto;

import com.salesianostriana.dam.relaciones.model.Cliente;

import java.util.Set;
import java.util.stream.Collectors;

public record GetClienteWithTatuador(
        Long id,
        String nombre,
        Set<GetTatuadorFromCliente> tatuadores
) {

    public static GetClienteWithTatuador of (Cliente cliente) {

        return new GetClienteWithTatuador(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getTatuadores()
                        .stream()
                        .map(GetTatuadorFromCliente::of)
                        .collect(Collectors.toSet())
        );
    }
}
