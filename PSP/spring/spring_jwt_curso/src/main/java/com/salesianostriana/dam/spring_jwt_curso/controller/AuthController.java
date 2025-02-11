package com.salesianostriana.dam.spring_jwt_curso.controller;

import com.salesianostriana.dam.spring_jwt_curso.dto.CreateUserDto;
import com.salesianostriana.dam.spring_jwt_curso.dto.LoginReponse;
import com.salesianostriana.dam.spring_jwt_curso.dto.LoginRequest;
import com.salesianostriana.dam.spring_jwt_curso.model.Usuario;
import com.salesianostriana.dam.spring_jwt_curso.security.JwtTokenProvider;
import com.salesianostriana.dam.spring_jwt_curso.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public Usuario save(@RequestBody CreateUserDto userDto) {
        return usuarioService.save(userDto);
    }

    @PostMapping("/login")
    public LoginReponse login(@RequestBody LoginRequest loginRequest) {
        Authentication authDto = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());

        Authentication auth = this.authManager.authenticate(authDto);
        Usuario usuario = (Usuario) auth.getPrincipal();

        String token = this.jwtTokenProvider.generateToken(auth);

        return LoginReponse.of(usuario, token);
    }

    @PutMapping("/user/{username}/role/{role}")
    public Usuario changeUserRole(@PathVariable String username, @PathVariable String role) {
        return usuarioService.changeRole(username, role);
    }
 }
