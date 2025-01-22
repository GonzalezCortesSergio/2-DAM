package com.salesianostriana.dam.modelodatos_ejercicio3.controller;

import com.salesianostriana.dam.modelodatos_ejercicio3.dto.GetUsoFinalizadoDto;
import com.salesianostriana.dam.modelodatos_ejercicio3.dto.GetUsuarioDto;
import com.salesianostriana.dam.modelodatos_ejercicio3.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Controlador para gestionar el uso de bicicletas que tienen los usuarios")
public class UsuarioController {

    private final UsuarioService service;


    @Operation(summary = "Coges una bici")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",
                    description = "Se ha cogido la bici correctamente",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = GetUsuarioDto.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                                {
                                                    "id": 1,
                                                    "nombre": "Jacinto",
                                                    "numTarjeta": "123456789AC",
                                                    "pin": "1234",
                                                    "saldo": 20,
                                                    "uso": {
                                                                "id": 1,
                                                                "fechaInicio": "2025-01-22T12:46:22.492",
                                                                "bicicleta": {
                                                                                "id": 1,
                                                                                "marca": "Bici to wapa",
                                                                                "modelo": "El mejor",
                                                                                "estado": "Nueva"
                                                                            }
                                                            }
                                                }
                                            """
                            )
                    })}),

                    @ApiResponse(responseCode = "400",
                    description = "No se ha devuelto la última bicicleta que cogiste",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = {
                                    @ExampleObject(
                                            value = """
                                                        {
                                                            "type": "about:blank",
                                                            "title": "Bicicleta no devuelta",
                                                            "status": 400,
                                                            "detail": "Antes de coger una bicicleta tienes que dejar la que ya has cogido",
                                                            "instance": "/api/usuario/1/recoger/1"
                                                        }
                                                    """
                                    )
                            })
                    })
            }
    )
    @PutMapping("/{idUsuario}/recoger/{idBicicleta}")
    public GetUsuarioDto recogerBici(@PathVariable Long idUsuario, @PathVariable Long idBicicleta) {

        return GetUsuarioDto.of(service.recogerBici(idUsuario, idBicicleta));
    }

    @Operation(summary = "Dejas una bici en una estación")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Se ha dejado la bici correctamente",
                            content = {
                                    @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = GetUsoFinalizadoDto.class),
                                            examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                    "id": 1,
                                                                    "fechaInicio": "2025-01-22T23:32:23.23341",
                                                                    "fechaFin": "2025-01-22T23:42:23.232324",
                                                                    "coste": 2,
                                                                    "usuario": {
                                                                                    "id": 1,
                                                                                    "nombre": "Jacinto",
                                                                                    "numTarjeta": "123456789AV",
                                                                                    "saldo": 18
                                                                                },
                                                                    "bicicleta": {
                                                                                    "id": 1,
                                                                                    "marca": "La mejor 1",
                                                                                    "modelo": "Esakto",
                                                                                    "estado": "Nueva"
                                                                                },
                                                                    "estacion": {
                                                                                    "id": 1,
                                                                                    "numero": "1234A",
                                                                                    "nombre": "Estacion 1",
                                                                                    "coordenadas": "-2.12123123, 1.23123123",
                                                                                    "capacidad": 15
                                                                                }
                                                                }
                                                            """
                                            )
                                            }
                                    )
                            }
                    ),
                    @ApiResponse(responseCode = "400",
                    description = "No caben más bicicletas en la estación",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = {
                                    @ExampleObject(
                                            value = """
                                                        {
                                                            "type": "about:blank",
                                                            "title": "Sin espacio",
                                                            "status": 400,
                                                            "detail": "No caben más bicicletas en la estación",
                                                            "instance": "/api/usuario/1/dejar/1"
                                                        }
                                                    """
                                    )
                            })
                    })
            }
    )
    @PutMapping("/{idUsuario}/dejar/{idEstacion}")
    public GetUsoFinalizadoDto dejarBici(@PathVariable Long idUsuario, @PathVariable Long idEstacion) {

        return GetUsoFinalizadoDto.of(service.dejarBici(idUsuario, idEstacion));
    }


}
