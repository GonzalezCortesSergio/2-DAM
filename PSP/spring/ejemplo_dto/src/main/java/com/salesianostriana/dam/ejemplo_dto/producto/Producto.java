package com.salesianostriana.dam.ejemplo_dto.producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Producto {

    private Long id;
    private String nombre;
    private String desc;
    private double pvp;
    private List<String> imagenes = new ArrayList<>();
    private Categoria categoria;
}
