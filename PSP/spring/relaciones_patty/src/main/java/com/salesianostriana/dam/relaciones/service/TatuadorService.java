package com.salesianostriana.dam.relaciones.service;

import com.salesianostriana.dam.relaciones.model.Tatuador;
import com.salesianostriana.dam.relaciones.repo.ClienteRepository;
import com.salesianostriana.dam.relaciones.repo.TatuadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TatuadorService {

    private final TatuadorRepository tatuadorRepository;
    private final ClienteRepository clienteRepository;


    public List<Tatuador> findAll() {

        return tatuadorRepository.findAll();
    }

    
}
