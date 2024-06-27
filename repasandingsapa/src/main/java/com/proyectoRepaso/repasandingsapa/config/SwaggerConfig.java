package com.proyectoRepaso.repasandingsapa.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase encargada de la documentacion de la aplicacion
 * @author jimenasepulveda@comfama.com.co
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().components(new Components()).info(new Info().title("repaso API")
                .description("App de prueba"));
    }
}
