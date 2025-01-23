package com.salesianostriana.dam.modelodatos_ejercicio3.service;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import com.salesianostriana.dam.modelodatos_ejercicio3.repo.BicicletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;


    public List<Bicicleta> findByEstado(String estado) {

        return bicicletaRepository.findByEstado(estado);
    }

    public List<Bicicleta> findByEstacionNumero(String nombre) {

        return bicicletaRepository.findByEstacionNombre(nombre);
    }
}
