package com.salesianostriana.dam.relaciones.service;

import com.salesianostriana.dam.relaciones.model.Cliente;
import com.salesianostriana.dam.relaciones.model.Tatuador;
import com.salesianostriana.dam.relaciones.repo.ClienteRepository;
import com.salesianostriana.dam.relaciones.repo.TatuadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> findAll() {

        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {

        return clienteRepository.save(cliente);
    }
}
