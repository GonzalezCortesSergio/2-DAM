package com.salesianostriana.dam.ejemplo_jwt.user.controller;

import com.salesianostriana.dam.ejemplo_jwt.security.jwt.JwtProvider;
import com.salesianostriana.dam.ejemplo_jwt.user.dto.CreateUsuarioDto;
import com.salesianostriana.dam.ejemplo_jwt.user.dto.UsuarioResponseDto;
import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.user.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;


    @PostMapping("/auth/register")
    public ResponseEntity<UsuarioResponseDto> createUser(@RequestBody CreateUsuarioDto usuarioDto) {

        Usuario usuario = usuarioService.createUser(usuarioDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponseDto.of(usuario));
    }

    @PostMapping("/auth/register/admin")
    public ResponseEntity<UsuarioResponseDto> createAdmin(@RequestBody CreateUsuarioDto usuarioDto) {

        Usuario usuario = usuarioService.createAdmin(usuarioDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponseDto.of(usuario));
    }
}
