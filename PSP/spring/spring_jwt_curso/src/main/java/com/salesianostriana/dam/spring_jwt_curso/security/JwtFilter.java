package com.salesianostriana.dam.spring_jwt_curso.security;

import com.salesianostriana.dam.spring_jwt_curso.service.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

/**
 * Extrae el token JWT de la cabecera Authorization de la petición HTTP
 */
@Component
@RequiredArgsConstructor
@Log
public class JwtFilter extends OncePerRequestFilter {

    private final UsuarioService userService;
    private final JwtTokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = this.extractToken(request);

        if(this.tokenProvider.isValidToken(token)){

            UUID id = this.tokenProvider.getIdFromToken(token);

            UserDetails user = this.userService.findById(id);

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities()
            );

            auth.setDetails(new WebAuthenticationDetails(request));

            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasLength(bearerToken) && bearerToken.startsWith("Bearer ")) {

            return bearerToken.substring("Bearer ".length());
        }

        return null;
    }
}
