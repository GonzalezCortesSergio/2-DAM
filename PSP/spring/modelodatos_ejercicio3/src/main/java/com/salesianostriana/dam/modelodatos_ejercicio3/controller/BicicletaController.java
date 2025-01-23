package com.salesianostriana.dam.modelodatos_ejercicio3.controller;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import com.salesianostriana.dam.modelodatos_ejercicio3.service.BicicletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bicicleta")
public class BicicletaController {

    private final BicicletaService service;

    @GetMapping("/{nombreEstacion}")
    public List<Bicicleta> findByNombreEstacion(@PathVariable String nombreEstacion) {

        return service.findByEstacionNumero(nombreEstacion);
    }
}
