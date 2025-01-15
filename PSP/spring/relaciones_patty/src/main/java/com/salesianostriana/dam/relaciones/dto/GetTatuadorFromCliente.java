package com.salesianostriana.dam.relaciones.dto;

import com.salesianostriana.dam.relaciones.model.Tatuador;

public record GetTatuadorFromCliente(
        Long id,
        String nombre,
        String estilo
) {

    public static GetTatuadorFromCliente of (Tatuador tatuador) {

        return new GetTatuadorFromCliente(
                tatuador.getId(),
                tatuador.getNombre(),
                tatuador.getEstilo()
        );
    }
}
