package com.salesianostriana.dam.ejemplo_dto.alumno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Curso {

    private Long id;
    private String nombre, tipo, tutor, aula;
}
