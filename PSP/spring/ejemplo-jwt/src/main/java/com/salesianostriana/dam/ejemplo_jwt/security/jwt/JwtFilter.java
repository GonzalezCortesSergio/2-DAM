package com.salesianostriana.dam.ejemplo_jwt.security.jwt;

import com.salesianostriana.dam.ejemplo_jwt.security.error.JwtTokenException;
import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import com.salesianostriana.dam.ejemplo_jwt.user.service.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.UUID;

@Log
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final UsuarioService usuarioService;
    private final JwtProvider provider;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;


    public String getTokenFromRequest(HttpServletRequest request) {

        String bearer = request.getHeader(JwtProvider.TOKEN_HEADER);
        if(StringUtils.hasText(bearer) && bearer.startsWith(JwtProvider.TOKEN_PREFIX)) {

            return bearer.substring(JwtProvider.TOKEN_PREFIX.length());
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromRequest(request);

        try {

            if (StringUtils.hasText(token) && provider.isTokenValid(token)) {

                UUID id = provider.getUsuarioIdFromToken(token);

                Usuario usuario = usuarioService.findById(id);

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(
                                usuario,
                                null,
                                usuario.getAuthorities()
                        );

                auth.setDetails(new WebAuthenticationDetails(request));

                SecurityContextHolder.getContext().setAuthentication(auth);
            }

            filterChain.doFilter(request, response);
        }catch (JwtTokenException ex) {
            log.info("Authentication error using token JWT: %s".formatted(ex.getMessage()));
            resolver.resolveException(request, response, null, ex);
        }
    }
}
