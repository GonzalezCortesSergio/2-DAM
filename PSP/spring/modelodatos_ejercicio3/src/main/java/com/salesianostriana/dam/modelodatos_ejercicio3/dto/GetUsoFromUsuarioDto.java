package com.salesianostriana.dam.modelodatos_ejercicio3.dto;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Uso;

import java.time.LocalDateTime;

public record GetUsoFromUsuarioDto(
        Long id,
        LocalDateTime fechaInicio,
        GetBicicletaFromUsoDto bicicleta
) {

    public static GetUsoFromUsuarioDto of (Uso uso) {

        return new GetUsoFromUsuarioDto(
                uso.getId(),
                uso.getFechaInicio(),
                GetBicicletaFromUsoDto.of(uso.getBicicleta())
        );
    }
}
