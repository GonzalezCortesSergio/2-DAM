package com.salesianostriana.dam.ejemplo_dto.alumno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alumno {

    private Long id;
    private String nombre, apellido1, apellido2, telefono, email;
    private Direccion direccion;
    private Curso curso;
}
