package com.salesianostriana.dam.modelodatos_ejercicio3.dto;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Uso;

import java.time.LocalDateTime;

public record GetUsoFinalizadoDto(
        Long id,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        double coste,
        GetUsuarioFromUsoDto usuario,
        GetBicicletaFromUsoDto bicicleta,
        GetEstacionFromUsoDto estacion
) {

    public static GetUsoFinalizadoDto of (Uso uso) {

        return new GetUsoFinalizadoDto(
                uso.getId(),
                uso.getFechaInicio(),
                uso.getFechaFin(),
                uso.getCoste(),
                GetUsuarioFromUsoDto.of(uso.getUsuario()),
                GetBicicletaFromUsoDto.of(uso.getBicicleta()),
                GetEstacionFromUsoDto.of(uso.getEstacion())
        );
    }
}
