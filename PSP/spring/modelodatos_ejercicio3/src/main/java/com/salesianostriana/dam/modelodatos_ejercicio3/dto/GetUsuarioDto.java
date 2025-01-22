package com.salesianostriana.dam.modelodatos_ejercicio3.dto;


import com.salesianostriana.dam.modelodatos_ejercicio3.model.Usuario;

public record GetUsuarioDto(
        Long id,
        String nombre,
        String numTarjeta,
        String pin,
        double saldo,
        GetUsoFromUsuarioDto uso
) {

    public static GetUsuarioDto of (Usuario usuario) {

        return new GetUsuarioDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getNumTarjeta(),
                usuario.getPin(),
                usuario.getSaldo(),
                GetUsoFromUsuarioDto.of(usuario.getListaUsos().get(usuario.getListaUsos().size() - 1))
        );
    }
}
