package com.salesianostriana.dam.relaciones;

import com.salesianostriana.dam.relaciones.manytomany.Autor;
import com.salesianostriana.dam.relaciones.manytomany.AutorRepository;
import com.salesianostriana.dam.relaciones.manytomany.Libro;
import com.salesianostriana.dam.relaciones.manytomany.LibroRepository;
import com.salesianostriana.dam.relaciones.onetomany.Departamento;
import com.salesianostriana.dam.relaciones.onetomany.DepartamentoRepository;
import com.salesianostriana.dam.relaciones.onetomany.Empleado;
import com.salesianostriana.dam.relaciones.onetomany.EmpleadoRepository;
import com.salesianostriana.dam.relaciones.onetoone.Estudiante;
import com.salesianostriana.dam.relaciones.onetoone.EstudianteRepository;
import com.salesianostriana.dam.relaciones.onetoone.InformacionAdicional;
import com.salesianostriana.dam.relaciones.onetoone.InformacionAdicionalRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class PseudoMain {

    //OneToOne

    private final EstudianteRepository estudianteRepository;
    private final InformacionAdicionalRepository infoRepository;

    //OneToMany

    private final DepartamentoRepository depRepository;
    private final EmpleadoRepository empRepository;

    //ManyToMany

    private final AutorRepository authRepository;
    private final LibroRepository libroRepository;

    @PostConstruct
    public void init() {

        // OneToOne

        Estudiante estudiante = Estudiante.builder().nombre("Miguel").apellidos("Garfia Bermúdez").curso("2ºDAM").edad(22).build();
        InformacionAdicional infoAdicional = InformacionAdicional.builder().dni("12345678A").telefono("123456789").email("garfia.bermig23@triana.salesianos.edu").direccion("Desengaño, 21").build();

        estudiante.addInformacion(infoAdicional);

        infoRepository.save(infoAdicional);
        estudianteRepository.save(estudiante);

        estudianteRepository.findAll().forEach(System.out::println);

        //OneToMany

        Empleado empleado = Empleado.builder().nombre("Manolo").apellidos("López Pérez").salario(1500.45).build();
        Departamento departamento = Departamento.builder().nombre("Empresa").direccion("Dirección").build();

        departamento.addEmpleado(empleado);


        depRepository.save(departamento);
        empRepository.save(empleado);


        empRepository.findAll().forEach(System.out::println);


        //ManyToMany

        Libro libro = Libro.builder().nombre("Memorias de Hidún I: La Resistencia").numPaginas(560).fechaPublicacion(LocalDate.of(2004, 9, 29)).build();
        Autor autor = Autor.builder().nombre("Laura").apellidos("Gallego").build();

        libro.addAutor(autor);

        libroRepository.save(libro);
        authRepository.save(autor);


        libroRepository.findAll().forEach(System.out::println);
    }
}
