package com.salesianostriana.dam.spring_jwt_curso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld() {

        return "Hello world";
    }

    @GetMapping("/writer/hello")
    public String writerHelloWorld() {

        return "Hello writer";
    }
}
