package com.salesianostriana.dam.modelodatos_ejercicio3.dto;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;

public record GetBicicletaFromUsoDto(
        Long id,
        String marca,
        String modelo,
        String estado
) {

    public static GetBicicletaFromUsoDto of (Bicicleta bicicleta) {

        return new GetBicicletaFromUsoDto(
                bicicleta.getId(),
                bicicleta.getMarca(),
                bicicleta.getModelo(),
                bicicleta.getEstado()
        );
    }
}
