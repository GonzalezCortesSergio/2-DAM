package com.salesianostriana.dam.modelodatos_ejercicio3.dto;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Usuario;

public record GetUsuarioFromUsoDto(
        Long id,
        String nombre,
        String numTarjeta,
        double saldo
) {

    public static GetUsuarioFromUsoDto of (Usuario usuario) {

        return new GetUsuarioFromUsoDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getNumTarjeta(),
                usuario.getSaldo()
        );
    }
}
