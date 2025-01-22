package com.salesianostriana.dam.modelodatos_ejercicio3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				description = "API para gestionar el uso de bicicletas como en Sevici",
				version = "1.0",
				contact = @Contact(
						email = "gonzalez.coser24@triana.salesianos.edu",
						name = "Sergio"
				),
				license = @License(
						name = "Sergio González Cortés"
				),
				title = "API sobre bicicletas"
		)
)
public class ModelodatosEjercicio3Application {

	public static void main(String[] args) {
		SpringApplication.run(ModelodatosEjercicio3Application.class, args);
	}

}
