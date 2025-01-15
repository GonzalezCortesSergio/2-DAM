package com.salesianostriana.dam.relaciones;

import com.salesianostriana.dam.relaciones.model.Cliente;
import com.salesianostriana.dam.relaciones.model.Tatuador;
import com.salesianostriana.dam.relaciones.repo.ClienteRepository;
import com.salesianostriana.dam.relaciones.repo.TatuadorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PseudoMain {

    private final TatuadorRepository tatuadorRepository;
    private final ClienteRepository clienteRepository;


    @PostConstruct
    public void init() {

        Tatuador tatuador = Tatuador.builder().nombre("Jacinto").estilo("Tradicional").build();
        Cliente cliente = Cliente.builder().nombre("Miguel").build();

        tatuador.addCliente(cliente);

        clienteRepository.save(cliente);
        tatuadorRepository.save(tatuador);


        tatuadorRepository.findAll().forEach(System.out::println);
    }
}
