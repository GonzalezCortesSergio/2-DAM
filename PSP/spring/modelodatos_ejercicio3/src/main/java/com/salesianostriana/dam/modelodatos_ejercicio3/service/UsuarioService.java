package com.salesianostriana.dam.modelodatos_ejercicio3.service;

import com.salesianostriana.dam.modelodatos_ejercicio3.error.*;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Bicicleta;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Estacion;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Uso;
import com.salesianostriana.dam.modelodatos_ejercicio3.model.Usuario;
import com.salesianostriana.dam.modelodatos_ejercicio3.repo.BicicletaRepository;
import com.salesianostriana.dam.modelodatos_ejercicio3.repo.EstacionRepository;
import com.salesianostriana.dam.modelodatos_ejercicio3.repo.UsoRepository;
import com.salesianostriana.dam.modelodatos_ejercicio3.repo.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BicicletaRepository bicicletaRepository;
    private final EstacionRepository estacionRepository;
    private final UsoRepository usoRepository;


    public List<Usuario> findAll() {

        List<Usuario> result = usuarioRepository.findAll();

        if(result.isEmpty())
            throw new UsuarioNotFoundException("No se ha encontrado ningún usuario");

        return result;
    }

    public Usuario findById(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(
                        () -> new UsuarioNotFoundException("No se ha encontrado un usuario con el ID: %d".formatted(id))
                );
    }

    public Usuario save(Usuario usuario){

        return usuarioRepository.save(usuario);
    }

    public Usuario edit(Usuario usuario, Long id) {

        return usuarioRepository.findById(id)
                .map(antiguo -> {

                    antiguo.setPin(usuario.getPin());
                    antiguo.setSaldo(usuario.getSaldo());
                    antiguo.setNombre(usuario.getNombre());

                    return usuarioRepository.save(antiguo);
                }).orElseThrow(
                        () -> new UsuarioNotFoundException("No se ha encontrado un usuario con el ID: %d".formatted(id))
                );
    }

    public void delete(Long id) {

        usuarioRepository.deleteById(id);
    }

    public Usuario recogerBici(Long idUsuario, Long idBicicleta) {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException("No se ha encontrado el usuario con ID: %d".formatted(idUsuario)));
        if(!usuario.getListaUsos().stream().filter(uso -> !uso.isTerminado()).toList().isEmpty())
            throw new BicicletaNotDevueltaException();

        Bicicleta bicicleta = bicicletaRepository.findById(idBicicleta)
                        .orElseThrow(() -> new BicicletaNotFoundException("No se ha encontrado ninguna bicicleta con el ID: %d".formatted(idBicicleta)));

        Estacion estacion = bicicleta.getEstacion();

                estacion.removeBicicleta(bicicleta);

        estacionRepository.save(estacion);

        Uso uso = Uso.builder()
                .fechaInicio(LocalDateTime.now())
                .build();

        bicicleta.addUso(uso);

        usuario.addUso(uso);
        bicicletaRepository.save(bicicleta);
        usoRepository.save(uso);

        return usuarioRepository.save(usuario);

    }

    public Uso dejarBici(Long idUsuario, Long idEstacion) {

        Estacion estacion = estacionRepository.findById(idEstacion)
                .orElseThrow(() -> new EstacionNotFoundException("No se ha encontrado ninguna estación con el ID: %d".formatted(idEstacion)));
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException("No se ha encontrado un usuario con el ID: %d".formatted(idUsuario)));
        if(usuario.getListaUsos().isEmpty())
            throw new SinBicicletaException();

        double precioMinuto = 0.20;

        Uso uso = usuario.getListaUsos().get(usuario.getListaUsos().size() - 1);

        uso.setFechaFin(LocalDateTime.now());

        LocalDateTime diferencia = uso.getFechaFin()
                .minusHours(uso.getFechaInicio().getHour())
                .minusMinutes(uso.getFechaInicio().getMinute())
                .minusSeconds(uso.getFechaInicio().getSecond());

        double costeFinal = (diferencia.getHour() * 60 + diferencia.getMinute()) * precioMinuto;

        uso.setTerminado(true);
        uso.setCoste(costeFinal);

        if(estacion.getListaBicicletas().size() >= estacion.getCapacidad())
            throw new EstacionLlenaException();

        Bicicleta bicicletaUsada = uso.getBicicleta();

        estacion.addBicicleta(bicicletaUsada);

        uso.setEstacion(estacion);

        usuario.setSaldo(usuario.getSaldo() - uso.getCoste());

        estacionRepository.save(estacion);

        bicicletaRepository.save(bicicletaUsada);

        usuarioRepository.save(usuario);

        return usoRepository.save(uso);

    }
}
