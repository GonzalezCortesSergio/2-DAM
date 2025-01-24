package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.model.joined.Animal;
import com.salesianostriana.dam.herencia.model.joined.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("""
            select a
            from Animal a
            where type(a) = Mascota
            """)
    List<Mascota> mascotas();
}
