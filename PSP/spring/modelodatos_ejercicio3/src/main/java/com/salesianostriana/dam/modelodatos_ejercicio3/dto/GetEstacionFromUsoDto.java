package com.salesianostriana.dam.modelodatos_ejercicio3.dto;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Estacion;

public record GetEstacionFromUsoDto(
        Long id,
        String numero,
        String nombre,
        String coordenadas,
        int capacidad
) {
    public static GetEstacionFromUsoDto of (Estacion estacion) {

        return new GetEstacionFromUsoDto(
                estacion.getId(),
                estacion.getNumero(),
                estacion.getNombre(),
                estacion.getCoordenadas(),
                estacion.getCapacidad()
        );
    }
}
