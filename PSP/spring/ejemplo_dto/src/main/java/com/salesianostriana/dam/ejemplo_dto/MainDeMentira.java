package com.salesianostriana.dam.ejemplo_dto;

import com.salesianostriana.dam.ejemplo_dto.alumno.Alumno;
import com.salesianostriana.dam.ejemplo_dto.alumno.AlumnoDTO;
import com.salesianostriana.dam.ejemplo_dto.alumno.Curso;
import com.salesianostriana.dam.ejemplo_dto.alumno.Direccion;
import com.salesianostriana.dam.ejemplo_dto.producto.Categoria;
import com.salesianostriana.dam.ejemplo_dto.producto.Producto;
import com.salesianostriana.dam.ejemplo_dto.producto.ProductoDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainDeMentira {

    @PostConstruct
    public void init() {

        Direccion direccion = Direccion.builder().id(1L).tipoVia("Calle").linea1("Virgen de Luján").linea2("Nº2").cp("41009").poblacion("Sevilla").provincia("Sevilla").build();
        Curso curso = Curso.builder().id(1L).nombre("1ºDAM").tipo("Tecnológico").tutor("Rafael Villar").aula("Aula de primero DAM").build();
        Alumno alumno = Alumno.builder().id(1L).nombre("Manolo").apellido1("Lama").apellido2("Benítez").telefono("668887971").email("manolitox171@gmail.com").direccion(direccion).curso(curso).build();

        System.out.println("ALUMNO: ");
        System.out.println();
        
        System.out.println(AlumnoDTO.of(alumno));
        System.out.println();


        Categoria categoria = Categoria.builder().id(1L).nombre("Alimentación").build();
        Producto producto = Producto.builder().id(1L).nombre("Snicker").desc("Un snicker to weno, quién le diría que no a un snicker").pvp(2.20).imagenes(List.of("imagen_snicker")).categoria(categoria).build();

        System.out.println("PRODUCTO: ");
        System.out.println();
        System.out.println(ProductoDTO.of(producto));
        System.out.println();
    }
}
