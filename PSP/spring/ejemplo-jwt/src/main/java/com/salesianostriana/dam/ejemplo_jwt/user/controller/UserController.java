package com.salesianostriana.dam.ejemplo_jwt.user.controller;

import com.salesianostriana.dam.ejemplo_jwt.security.jwt.access.JwtProvider;
import com.salesianostriana.dam.ejemplo_jwt.security.jwt.refresh.JwtRefresh;
import com.salesianostriana.dam.ejemplo_jwt.security.jwt.refresh.JwtRefreshService;
import com.salesianostriana.dam.ejemplo_jwt.security.jwt.refresh.RefreshTokenRequest;
import com.salesianostriana.dam.ejemplo_jwt.user.dto.CreateUsuarioDto;
import com.salesianostriana.dam.ejemplo_jwt.user.dto.LoginRequest;
import com.salesianostriana.dam.ejemplo_jwt.user.dto.UsuarioResponseDto;
import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.user.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;
    private final JwtRefreshService jwtRefreshService;


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

    @PostMapping("/auth/login")
    public ResponseEntity<UsuarioResponseDto> login(@RequestBody LoginRequest loginRequest) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
        );

        Usuario usuario = (Usuario) auth.getPrincipal();

        String token = jwtProvider.generateToken(usuario);
        JwtRefresh refreshToken = jwtRefreshService.create(usuario);


        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponseDto.of(usuario, token, refreshToken.getToken()));
    }

    @GetMapping("/me")
    public UsuarioResponseDto me(@AuthenticationPrincipal Usuario usuario) {

        return UsuarioResponseDto.of(usuario);
    }

    @GetMapping("/me/admin")
    public UsuarioResponseDto meAdmin(@AuthenticationPrincipal Usuario usuario) {

        return UsuarioResponseDto.of(usuario);
    }

    @PutMapping("/auth/admin/changeroleadmin/user/{username}")
    public UsuarioResponseDto changeRoleAdmin (@PathVariable String username) {

        return UsuarioResponseDto.of(usuarioService.changeRoleToAdmin(username));
    }

    @PutMapping("/auth/admin/changeroleuser/user/{username}")
    public UsuarioResponseDto changeRoleUser(@PathVariable String username) {

        return UsuarioResponseDto.of(usuarioService.changeRoleToUser(username));
    }


    @PostMapping("/auth/refresh/token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest req) {

        String token = req.token();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jwtRefreshService.refreshToken(token));
    }
}
