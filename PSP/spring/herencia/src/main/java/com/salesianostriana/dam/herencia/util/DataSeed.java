package com.salesianostriana.dam.herencia.util;

import com.salesianostriana.dam.herencia.model.joined.Animal;
import com.salesianostriana.dam.herencia.model.joined.Mascota;
import com.salesianostriana.dam.herencia.model.mappedsuperclass.Coche;
import com.salesianostriana.dam.herencia.model.mappedsuperclass.Moto;
import com.salesianostriana.dam.herencia.repo.AnimalRepository;
import com.salesianostriana.dam.herencia.repo.CocheRepository;
import com.salesianostriana.dam.herencia.repo.MotoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final MotoRepository motoRepository;
    private final CocheRepository cocheRepository;
    private final AnimalRepository animalRepository;

    @PostConstruct
    public void init() {

        Moto moto = Moto.builder()
                .km(200000L)
                .modelo("Kawasaki ninja")
                .cilindrada(450)
                .numRuedas(2)
                .build();

        motoRepository.save(moto);

        motoRepository.findAll().forEach(System.out::println);

        Coche coche = Coche.builder()
                .km(40000000L)
                .modelo("Yokesedecoches")
                .numRuedas(4)
                .numPlazas(5)
                .build();

        cocheRepository.save(coche);

        cocheRepository.findAll().forEach(System.out::println);

        Animal animal = Animal.builder()
                .especie("Cocodrilo")
                .build();

        animalRepository.save(animal);

        Animal mascota = Mascota.builder()
                .especie("Perro")
                .nombre("Juancho")
                .duenio("Juan")
                .build();

        animalRepository.save(mascota);

        animalRepository.findAll().forEach(System.out::println);

        animalRepository.mascotas().forEach(System.out::println);
    }
}
