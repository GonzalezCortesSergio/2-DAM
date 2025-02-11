package com.salesianostriana.dam.ejemplo_jwt.controller;

import com.salesianostriana.dam.ejemplo_jwt.dto.CreateUsuarioDto;
import com.salesianostriana.dam.ejemplo_jwt.dto.GetUsuarioResponseDto;
import com.salesianostriana.dam.ejemplo_jwt.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/auth/registro")
    public ResponseEntity<GetUsuarioResponseDto> crearUsuarioUser(@RequestBody CreateUsuarioDto usuarioDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(GetUsuarioResponseDto.of(usuarioService.crearUsuarioUser(usuarioDto)));
    }
}
