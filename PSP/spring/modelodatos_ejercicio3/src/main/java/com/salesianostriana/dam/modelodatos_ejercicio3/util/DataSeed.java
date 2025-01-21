package com.salesianostriana.dam.modelodatos_ejercicio3.util;

import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Estacion;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Uso;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Usuario;
import com.salesianostriana.dam.modelodatos_ejercicio3.repo.BicicletaRepository;
import com.salesianostriana.dam.modelodatos_ejercicio3.repo.EstacionRepository;
import com.salesianostriana.dam.modelodatos_ejercicio3.repo.UsoRepository;
import com.salesianostriana.dam.modelodatos_ejercicio3.repo.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final BicicletaRepository bicicletaRepository;
    private final EstacionRepository estacionRepository;
    private final UsoRepository usoRepository;
    private final UsuarioRepository usuarioRepository;


    @PostConstruct
    public void init() {

        Bicicleta bicicleta = Bicicleta.builder()
                .marca("Marca Bicicleta to wapa")
                .modelo("El mejor")
                .estado("Como nueva")
                .build();

        Estacion estacion = Estacion.builder()
                .numero("41A")
                .nombre("Estacion 1")
                .coordenadas("4.12312314, 2.121231")
                .capacidad(15)
                .build();

        Uso uso = Uso.builder()
                .fechaInicio(LocalDateTime.of(2025, 1, 21, 19, 9, 22))
                .fechaFin(LocalDateTime.of(2025, 1, 21, 20, 8, 23))
                .coste(7.85)
                .build();

        Usuario usuario = Usuario.builder()
                .nombre("Manolo")
                .numTarjeta("12345678ACV")
                .pin("1234")
                .saldo(20)
                .build();

        usuarioRepository.save(usuario);
        bicicletaRepository.save(bicicleta);
        estacionRepository.save(estacion);
        usoRepository.save(uso);

        usuario.addUso(uso);

        bicicleta.addUso(uso);

        try {

            estacion.addBicicleta(bicicleta);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        uso.setEstacion(estacion);

        usuarioRepository.save(usuario);
        bicicletaRepository.save(bicicleta);
        estacionRepository.save(estacion);
        usoRepository.save(uso);


        usuarioRepository.findAll().forEach(System.out::println);
    }
}
