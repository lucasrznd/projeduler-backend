package com.lucasrznd.projedulerbackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.open-api.title}") final String title,
                                 @Value("${springdoc.open-api.description}") final String description,
                                 @Value("${springdoc.open-api.version}") final String version) {
        return new OpenAPI()
                .info(
                        new Info().title(title).description(description).version(version)
                );
    }

}
