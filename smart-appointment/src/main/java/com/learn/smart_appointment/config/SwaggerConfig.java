package com.learn.smart_appointment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Smart Appointment API")
                .version("1.0")
                .description("Backend API for managing users, providers, appointments, services, reviews, and notifications in the Smart Appointment System.")
                .contact(new Contact()
                    .name("Abdulrahman Ahmed")
                    .email("abdulrahman.ahmedd@gmail.com")
                )
            );
    }
}
